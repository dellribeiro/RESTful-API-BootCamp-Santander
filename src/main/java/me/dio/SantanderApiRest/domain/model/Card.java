package me.dio.SantanderApiRest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The number field can't be blank.")
    @Pattern(regexp = "\\d{16}", message = "Please enter a valid card number (16 digits)")
    @Column(unique = true)
    private String number;

    @NotNull(message = "The expirationDate field can't be blank.")
    @Future(message = "Invalid date")
    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "available_limit", scale = 2, precision = 13)
    private BigDecimal limit;

    @OneToOne(mappedBy = "card")
    private User user;
}
