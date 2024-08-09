package cn.infinitumstudios.infinitumEconomy.foundation;

import cn.infinitumstudios.infinitumEconomy.foundation.interfaces.IJsonConvertible;
import com.google.gson.JsonObject;

public class Currency implements IJsonConvertible<Currency> {
    public static Currency DEFAULT = new Currency("Fractal", "Fractals", "Σ");

    private final String name, pluralName, symbol;
    private final double currencyWorth;

    public Currency(String name, String pluralName, String symbol, double currencyWorth) {
        this.name = name;
        this.pluralName = pluralName;
        this.symbol = symbol;
        this.currencyWorth = currencyWorth;
    }

    public Currency(String name, String pluralName, String symbol) {
        this(name, pluralName, symbol, 1.0);
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getCurrencyWorth() {
        return currencyWorth;
    }

    public String getPluralName() {
        return pluralName;
    }

    public String value(double value, boolean useSymbol){
        if(useSymbol)
            return String.format("%.2f%s", value, getSymbol());
        return String.format("%.2f %s", value, value <= 1 ? getName() : getPluralName());
    }

    @Override
    public JsonObject toJson() {
        return null;
    }

    @Override
    public Currency fromJson(JsonObject object) {
        return null;
    }
}
