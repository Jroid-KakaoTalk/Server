package jroid.kakaotalk.server.entity.quest;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestRewardIntimacy {
    
    @EmbeddedId
    QuestRewardIntimacyPk pk;
    
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer intimacy;
    
}