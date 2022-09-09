package org.magm.backend.integration.cli2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "cli2_items")
@PrimaryKeyJoinColumn(name = "id_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemCli2 implements Serializable {

	private static final long serialVersionUID = 8383230451499291477L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@ManyToOne
	@JoinColumn(name="id_product", nullable = false)
    private ProductCli2 product;
	
    @Column(nullable = false)
    private double cantidad;
    
    @Column(nullable = false)
    private double precio; 
    

}
