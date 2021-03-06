package jroid.kakaotalk.server.entity.quest;

import jroid.kakaotalk.server.entity.item.Item;
import lombok.*;

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
public class QuestRewardItemPk implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "quest_id")
    Quest quest;
    
    @ManyToOne
    @JoinColumn(name = "item_id")
    Item item;
    
    @Override
    public int hashCode() {
        return quest.id.hashCode() ^ item.getId().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof QuestRewardItemPk) {
            QuestRewardItemPk pk = (QuestRewardItemPk) obj;
            return quest.id.equals(pk.quest.id) &&
                item.getId().equals(pk.item.getId());
        } else {
            return false;
        }
    }
    
}