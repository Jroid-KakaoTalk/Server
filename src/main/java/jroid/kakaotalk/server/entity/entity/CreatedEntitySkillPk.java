package jroid.kakaotalk.server.entity.entity;

import jroid.kakaotalk.server.entity.player.Skill;
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
public class CreatedEntitySkillPk implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "created_entity_id")
    CreatedEntity createdEntity;
    
    @ManyToOne
    @JoinColumn(name = "skill_id")
    Skill skill;
    
    @Override
    public int hashCode() {
        return createdEntity.id.hashCode() ^ skill.getId().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof CreatedEntitySkillPk) {
            CreatedEntitySkillPk pk = (CreatedEntitySkillPk) obj;
            return createdEntity.id.equals(pk.createdEntity.id) &&
                skill.getId().equals(pk.skill.getId());
        } else {
            return false;
        }
    }
    
}