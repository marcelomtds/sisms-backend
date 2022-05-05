package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.model.dto.RelatorioItemSerieDTO;
import br.com.sisms.api.model.dto.RelatorioSerieDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.RelatorioAtendimentoPeriodoFilter;
import br.com.sisms.api.model.interfaces.IRelatorioItemSerie;
import br.com.sisms.api.repository.AtendimentoRepository;
import br.com.sisms.api.repository.CategoriaAtendimentoRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RelatorioService {

    private final AtendimentoRepository atendimentoRepository;
    private final CategoriaAtendimentoRepository categoriaAtendimentoRepository;

    @Transactional(readOnly = true)
    public List<RelatorioSerieDTO> reportServiceByFilter(final RelatorioAtendimentoPeriodoFilter filter) {
        validatePeriod(filter.getDataInicio(), filter.getDataFim());
        if (Objects.isNull(filter.getCategoriasAtendimentoId()) || filter.getCategoriasAtendimentoId().isEmpty()) {
            filter.setCategoriasAtendimentoId(categoriaAtendimentoRepository.findAll().stream().map(it -> it.getId()).collect(Collectors.toList()));
        }
        final List<RelatorioSerieDTO> series = new ArrayList<>();
        final List<IRelatorioItemSerie> items;
        if (filter.getAgruparPorMes()) {
            items = atendimentoRepository.reportGroupedServiceByFilter(filter.getDataInicio().atTime(00, 00, 00), filter.getDataFim().atTime(23, 59, 59), filter.getCategoriasAtendimentoId());
            Set<Long> anos = new HashSet<>();
            Set<Long> meses = new HashSet<>();
            items.forEach(it -> {
                anos.add(it.getAno());
                meses.add(it.getMes());
            });
            anos.forEach(anoIt -> {
                meses.forEach(mesIt -> {
                    List<RelatorioItemSerieDTO> item = new ArrayList<>();
                    items.forEach(itemIt -> {
                        if (mesIt.equals(itemIt.getMes()) && anoIt.equals(itemIt.getAno())) {
                            item.add(new RelatorioItemSerieDTO(itemIt.getName(), itemIt.getValue()));
                        }
                    });
                    if (ArrayUtils.isNotEmpty(item.toArray())) {
                        final RelatorioSerieDTO serie = new RelatorioSerieDTO();
                        serie.setSeries(item);
                        serie.setName(String.format("%s/%s", Util.findMonthNameByNumber(mesIt.intValue()), anoIt.toString()));
                        series.add(serie);
                    }
                });
            });
        } else {
            items = atendimentoRepository.reportServiceByFilter(filter.getDataInicio().atTime(00, 00, 00), filter.getDataFim().atTime(23, 59, 59), filter.getCategoriasAtendimentoId());
            if (ArrayUtils.isNotEmpty(items.toArray())) {
                final RelatorioSerieDTO serie = new RelatorioSerieDTO();
                serie.setName(String.format("%s - %s", Util.formatDateTimeToString(filter.getDataInicio()), Util.formatDateTimeToString(filter.getDataFim())));
                serie.setSeries(items.stream().map(it -> new RelatorioItemSerieDTO(it.getName(), it.getValue())).collect(Collectors.toList()));
                series.add(serie);
            }
        }
        return series;
    }

    private void validatePeriod(final LocalDate startDate, final LocalDate endDate) {
        if (Objects.nonNull(startDate) && Objects.nonNull(endDate) && Util.isInvalidPeriod(startDate, endDate)) {
            throw new BusinessException(MessageEnum.MSG0008.toString());
        }
    }
}
