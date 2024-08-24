package ecommerce.object_jars.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import ecommerce.object_jars.dto.NOrderConfirmation;
import ecommerce.object_jars.dto.PaymentConfirmation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    @JdbcTypeCode(SqlTypes.JSON)
    private NOrderConfirmation nOrderConfirmation;
    @JdbcTypeCode(SqlTypes.JSON)
    private PaymentConfirmation paymentConfirmation;
}