package br.com.sisms.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

public final class Util {

    public static Boolean isValidCpf(final String cpf) {
        if (!cpf.equals("00000000000") && !cpf.equals("11111111111") && !cpf.equals("22222222222")
                && !cpf.equals("33333333333") && !cpf.equals("44444444444") && !cpf.equals("55555555555")
                && !cpf.equals("66666666666") && !cpf.equals("77777777777") && !cpf.equals("88888888888")
                && !cpf.equals("99999999999") && cpf.length() == 11) {
            try {
                int sm = 0;
                int peso = 10;
                int i;
                int num;
                for (i = 0; i < 9; ++i) {
                    num = cpf.charAt(i) - 48;
                    sm += num * peso;
                    --peso;
                }
                int r = 11 - sm % 11;
                char dig10;
                if (r != 10 && r != 11) {
                    dig10 = (char) (r + 48);
                } else {
                    dig10 = '0';
                }
                sm = 0;
                peso = 11;
                for (i = 0; i < 10; ++i) {
                    num = cpf.charAt(i) - 48;
                    sm += num * peso;
                    --peso;
                }
                r = 11 - sm % 11;
                char dig11;
                if (r != 10 && r != 11) {
                    dig11 = (char) (r + 48);
                } else {
                    dig11 = '0';
                }
                return dig10 == cpf.charAt(9) && dig11 == cpf.charAt(10);
            } catch (InputMismatchException var9) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean isCurrentDateBeforeDate(final LocalDate date) {
        return LocalDate.now().isBefore(date);
    }

    public static Boolean isInvalidPeriod(final LocalDateTime startDateTime, final LocalDateTime endDateTime) {
        return endDateTime.isBefore(startDateTime);
    }

    public static Boolean isInvalidPeriod(final LocalDate startDate, final LocalDate endDate) {
        return endDate.isBefore(startDate);
    }

}
