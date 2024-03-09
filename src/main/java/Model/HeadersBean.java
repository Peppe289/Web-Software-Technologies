package Model;

import java.util.ArrayList;

public class HeadersBean {
    public ArrayList<String> headerNames;
    public ArrayList<String> headerValues;

    public HeadersBean() {
        headerNames = new ArrayList<>();
        headerValues = new ArrayList<>();
    }

    public void addHeaderValues(String element) {
        headerValues.add(element);
    }

    public void addHeaderNames(String element) {
        headerNames.add(element);
    }

    public ArrayList<String> getHeaderNames() {
        return headerNames;
    }

    public ArrayList<String> getHeaderValues() {
        return headerValues;
    }
}
