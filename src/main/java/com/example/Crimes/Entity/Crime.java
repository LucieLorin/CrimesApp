package com.example.Crimes.Entity;

import com.example.Crimes.Dtos.CrimeDto;
import com.example.Crimes.Dtos.MurdererDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crime")
public class Crime extends BaseEntity {

    //TODO: pridat vazbu

    @JoinColumn(name = "murderer_id")
    private Long murdererId;

    @JoinColumn(name = "country")
    private String country;

    @JoinColumn(name = "victims")
    private int victims;

    @JoinColumn(name = "details")
    private String details;

    public CrimeDto toCrimeDto() {
        var dto = new CrimeDto();
        BeanUtils.copyProperties(this, dto);
        return dto;

    }

//    public static Crime from(CrimeDto dto) {
//        var crime = new Crime();
//        BeanUtils.copyProperties(dto, crime, "id");
//        return crime;
//    }

}
