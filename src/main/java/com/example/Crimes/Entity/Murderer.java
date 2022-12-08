package com.example.Crimes.Entity;

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
@Table(name = "murderer")
public class Murderer extends BaseEntity {

    @JoinColumn(name = "birthdate")
    private String birthdate;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "surname")
    private String surname;

    /**
     * toDto method
     * BeanUtils.copyProperties
     * Copy the property values of the given source bean into the given target bean,
     * ignoring the given "ignoreProperties".
     */
    public MurdererDto toMurdererDto() {
        var dto = new MurdererDto();
        BeanUtils.copyProperties(this, dto);
        return dto;

    }

    /**
     * Prepared for FE → DB
     */
    public static Murderer from(MurdererDto dto) {
        var murderer = new Murderer();
        BeanUtils.copyProperties(dto, murderer, "id");
        return murderer;
    }

}
