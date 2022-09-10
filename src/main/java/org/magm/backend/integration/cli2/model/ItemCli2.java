package org.magm.backend.integration.cli2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

import org.magm.backend.model.Product;

@Entity
@Table(name = "cli2_items")
@PrimaryKeyJoinColumn(name = "id_item")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemCli2 implements Serializable {

	private static final long serialVersionUID = -2961182707848995352L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@ManyToOne
	@JoinColumn(name="id_product", nullable = true)
    private Product producto;
	
    @Column(nullable = false)
    private double cantidad;
    
    @Column(nullable = false)
    private double precio; 
    

}
