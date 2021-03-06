package jroid.kakaotalk.server.entity.player;

import jroid.kakaotalk.server.entity.GameLog;
import jroid.kakaotalk.server.entity.entity.CreatedEntityAngry;
import jroid.kakaotalk.server.entity.living.*;
import jroid.kakaotalk.server.entity.map.GameMap;
import jroid.kakaotalk.server.enums.Doing;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @Column(nullable = false)
    String sender;
    
    @Column(nullable = false)
    String image;
    
    @Column(nullable = false, length = 31, unique = true)
    String name;
    
    @CreationTimestamp
    @Column(nullable = false)
    LocalDateTime created;
    
    @UpdateTimestamp
    @Column(nullable = false)
    LocalDateTime updated;
    
    @Builder.Default
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer lv = 1;
    
    @Builder.Default
    @Column(nullable = false)
    Long exp = 0L;
    
    @Builder.Default
    @Column(nullable = false)
    Integer sp = 0;
    
    @Builder.Default
    @Column(columnDefinition = "BIGINT UNSIGNED NOT NULL")
    BigInteger money = new BigInteger("0");
    
    @Builder.Default
    @Column(columnDefinition = "TINYINT UNSIGNED NOT NULL")
    Integer doing = Doing.NONE.getValue();
    
    @Builder.Default
    @Column(columnDefinition = "TINYINT UNSIGNED NOT NULL")
    Integer farmLv = 0;
    
    @Builder.Default
    @Column(nullable = false, length = 63)
    String title = "초심자";
    
    @Builder.Default
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer continueDay = 0;
    
    @Builder.Default
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer adv = 0;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    GameMap gameMap;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    GameMap baseGameMap;
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.player", cascade = CascadeType.ALL)
    List<PlayerSkill> playerSkillList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<PlayerTitle> playerTitleList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<Planted> plantedList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.player", cascade = CascadeType.ALL)
    List<CreatedEntityAngry> createdEntityAngryList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<LivingEquipUnique> livingEquipUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<LivingEventUnique> livingEventUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<LivingItemUnique> livingItemUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<LivingStatUnique> livingStatUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<LivingVariableUnique> livingVariableUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    List<GameLog> gameLogList = new ArrayList<>();
    
}