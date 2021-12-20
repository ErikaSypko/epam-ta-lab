package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "filtersRozetka")
@XmlAccessorType(XmlAccessType.FIELD)
public class FiltersRozetka {
    @XmlElement(name = "filterRozetka")
    private List<FilterRozetka> filters;

    public List<FilterRozetka> getFilters() {
        return this.filters;
    }
}
