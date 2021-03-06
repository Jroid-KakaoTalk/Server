package jroid.kakaotalk.server.entity.entity;

import jroid.kakaotalk.server.entity.GameLog;
import jroid.kakaotalk.server.entity.living.*;
import jroid.kakaotalk.server.entity.map.GameMap;
import jroid.kakaotalk.server.enums.Doing;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatedEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @CreationTimestamp
    @Column(nullable = false)
    LocalDateTime created;
    
    @Builder.Default
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer lv = 1;
    
    @Builder.Default
    @Column(nullable = false)
    Long exp = 0L;
    
    @Builder.Default
    @Column(columnDefinition = "BIGINT UNSIGNED NOT NULL")
    BigInteger money = new BigInteger("0");
    
    @Builder.Default
    @Column(columnDefinition = "TINYINT UNSIGNED NOT NULL")
    Integer doing = Doing.NONE.getValue();
    
    @Column(nullable = false)
    Integer location;
    
    @ManyToOne
    @JoinColumn(name = "entity_id", nullable = false)
    Entity entity;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    GameMap gameMap;
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.createdEntity", cascade = CascadeType.ALL)
    List<CreatedEntitySkill> createdEntitySkillList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.createdEntity", cascade = CascadeType.ALL)
    List<CreatedEntityAngry> createdEntityAngryList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "createdEntity", cascade = CascadeType.ALL)
    List<LivingEquipUnique> livingEquipUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "createdEntity", cascade = CascadeType.ALL)
    List<LivingEventUnique> livingEventUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "createdEntity", cascade = CascadeType.ALL)
    List<LivingItemUnique> livingItemUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "createdEntity", cascade = CascadeType.ALL)
    List<LivingStatUnique> livingStatUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "createdEntity", cascade = CascadeType.ALL)
    List<LivingVariableUnique> livingVariableUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "createdEntity", cascade = CascadeType.ALL)
    List<CreatedEntityTag> createdEntityTagList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "createdEntity", cascade = CascadeType.ALL)
    List<GameLog> gameLogList = new ArrayList<>();
    
}