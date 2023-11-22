package lk.nexttravel.guideservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String name;
    String address;
    int age;
    String gender;
    String contact_number_01;
    @Lob // Large object - to store large binary data
    byte[] profile_image;
    @Lob
    byte[] nic_image;
    @Lob
    byte[] guide_id_scanned_image;
    String experience;
    double man_day_value;
    String remarks;
}
