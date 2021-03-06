package jroid.kakaotalk.server.entity.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatedEntityAngry {
    
    @EmbeddedId
    CreatedEntityAngryPk pk;
    
    @Column(nullable = false)
    LocalDateTime angryTime;
    
}