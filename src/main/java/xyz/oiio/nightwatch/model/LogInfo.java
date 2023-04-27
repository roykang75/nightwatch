package xyz.oiio.nightwatch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import xyz.oiio.nightwatch.converter.LocalDateTimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class LogInfo {

//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern="yyyy-MM-dd")
//    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")

//    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
//    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime timestamp;


    private String src;
    private String message;
    private String host;
    private String phase;
    private String service;
    private String thread;
    private String level;
    private String traceId;
    private String spanId;
    private String exception;
    private String eventId;
}
