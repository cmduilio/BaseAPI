package configuration;

import core.entities.Asociation;
import entrypoints.dtos.Charge;
import entrypoints.dtos.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class System {

    private static int lastChargeUnpaid = 0;
    private static Double debt = 0D;
    private static List<Charge> charges = new ArrayList<>();
    private static List<Payment> payments = new ArrayList<>();
    private static Map<Integer, List<Asociation>> asociations = new HashMap<>();

    public static List<Charge> getCharges() {
        return charges;
    }

    public static void setCharges(List<Charge> chgs) {
        charges = chgs;
    }

    public static Map<Integer, List<Asociation>> getAsociations() {
        return asociations;
    }

    public static void setAsociations(Map<Integer, List<Asociation>> asocs) {
        asociations = asocs;
    }

    public static List<Payment> getPayments() {
        return payments;
    }

    public static void setPayments(List<Payment> pays) {
        payments = pays;
    }

    public static int getLastChargeUnpaid() {
        return lastChargeUnpaid;
    }

    public static void setLastChargeUnpaid(int lastChargeUnpaid) {
        System.lastChargeUnpaid = lastChargeUnpaid;
    }

    public static Double getDebt() {
        return debt;
    }

    public static void setDebt(Double debt) {
        System.debt = debt;
    }
}
