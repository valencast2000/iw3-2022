package org.magm.backend.integration.cli2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cli2_facturas")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaCli2 implements Serializable {

	private static final long serialVersionUID = -8338132664128927339L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private long numero;

    @Column(nullable = false)
    private Date fechaEmision;

    @Column(nullable = false)
    private Date fechaVencimiento;

    @Column(columnDefinition = "tinyint default 0", nullable = false)
    private boolean anulada;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cli2_facturas_id", nullable = true)
    private Set<ItemCli2> items; 
    
    
    
    


}
