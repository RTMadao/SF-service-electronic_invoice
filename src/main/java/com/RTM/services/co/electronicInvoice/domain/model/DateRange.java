package com.RTM.services.co.electronicInvoice.domain.model;

import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlType(propOrder={"startDate","endDate"})
public class DateRange {
    private Date StartDate;
    private Date EndDate;

    public DateRange() {}
    public DateRange(Date startDate, Date endDate) {
        StartDate = startDate;
        EndDate = endDate;
    }
    @XmlElement(name = "StartDate", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getStartDate() {
        return DataFormatService.setDateFormat(StartDate);
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }
    @XmlElement(name = "EndDate", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getEndDate() {
        return DataFormatService.setDateFormat(EndDate);
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }
}
