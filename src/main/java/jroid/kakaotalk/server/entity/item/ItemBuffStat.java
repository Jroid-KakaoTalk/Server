package jroid.kakaotalk.server.entity.item;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemBuffStat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @Column(nullable = false)
    Integer time;
    
    @Column(columnDefinition = "TINYINT UNSIGNED NOT NULL")
    Integer statType;
    
    @Column(nullable = false)
    Integer stat;
    
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    Item item;
    
}