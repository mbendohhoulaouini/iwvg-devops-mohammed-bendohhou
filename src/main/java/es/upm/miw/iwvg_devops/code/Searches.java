package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll().filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream().filter(Fraction::isImproper)).map(Fraction::decimal);

    }

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll().filter(user -> user.getFractions().stream()
                .allMatch(Fraction::isProper))
                .map(User::getId).distinct();
    }

    public Stream<String> findUserIdByAnyProperFraction() {

        return new UsersDatabase().findAll().filter(user -> user.getFractions().stream()
                .anyMatch(Fraction::isImproper))
                .map(User::getId).distinct();
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream().filter(fraction -> fraction.getNumerator() < 0
                        || fraction.getDenominator() < 0)).map(Fraction::decimal);
    }

}