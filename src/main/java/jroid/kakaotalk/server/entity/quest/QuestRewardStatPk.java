package jroid.kakaotalk.server.entity.quest;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestRewardStatPk implements Serializable {
    
    @Column(columnDefinition = "TINYINT UNSIGNED")
    Integer statType;
    
    @ManyToOne
    @JoinColumn(name = "quest_id")
    Quest quest;
    
    @Override
    public int hashCode() {
        return quest.id.hashCode() ^ quest.getId().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof QuestRewardStatPk) {
            QuestRewardStatPk pk = (QuestRewardStatPk) obj;
            return quest.id.equals(pk.quest.id) &&
                quest.getId().equals(pk.quest.getId());
        } else {
            return false;
        }
    }
    
}