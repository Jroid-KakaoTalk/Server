package jroid.kakaotalk.server.entity.player;

import jroid.kakaotalk.server.entity.entity.CreatedEntitySkill;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    
    @Id
    @Column
    Long id;
    
    @Column(nullable = false, length = 63, unique = true)
    String passiveDes;
    
    @Column(nullable = false, length = 63, unique = true)
    String activeDes;
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.skill", cascade = CascadeType.ALL)
    List<PlayerSkill> playerSkillList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.skill", cascade = CascadeType.ALL)
    List<CreatedEntitySkill> createdEntitySkillList = new ArrayList<>();
    
}