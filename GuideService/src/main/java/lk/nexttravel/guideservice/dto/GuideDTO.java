package lk.nexttravel.guideservice.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lk.nexttravel.guideservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuideDTO {
    @NotBlank (message = "ID field cannot be empty")
    String id;

    @NotBlank (message = "Name field cannot be empty")
    String name;

    @NotBlank (message = "Address field cannot be empty")
    String address;

    @NotBlank (message = "Age field cannot be empty")
    @Max(90)
    @Min(18)
    int age;

    @NotBlank (message = "Please select a gender")
    Gender gender;

    @NotBlank (message = "Contact number field cannot be empty")
    @Pattern(regexp = "[0-9]{10}")
    String contact_number_01;

    @Lob // Large object - to store large binary data
    byte[] profile_image;

    @Lob
    @NotEmpty(message = "NIC image field cannot be empty")
    byte[] nic_image;

    @Lob
    @NotEmpty(message = "Guide ID image field cannot be empty")
    byte[] guide_id_scanned_image;

    String experience;

    double man_day_value; // assign a default value if a value is not given

    String remarks;

}
