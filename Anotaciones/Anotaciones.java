/* @Entity Indica que una clase es una entidad y se debe mapear a una tabla de la base de datos*/

/* @Table(name = "productos") Especifica el nombre de la tabla en la base de datos a la que se mapea la entidad. */

@Entity
@Table(name = "productos")
public class Producto { 

    /*@OneToOne, @OneToMany, @ManyToOne, @ManyToMany: Definen las relaciones entre entidades.*/
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();
  
    /* @Id Indica el campo que actúa como clave primaria de la entidad.*/
    /*@GeneratedValue(strategy = GenerationType.IDENTITY) Define la estrategia para generar el valor de la clave primaria. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    /*@Column Mapea un atributo a una columna específica en la tabla, permitiendo configurar detalles como el nombre, la longitud, la nulabilidad, etc*/
    @Column(name = "nombre", nullable = false)
    private String nombre;  

    /*@Transient Indica que un atributo no debe ser persistido en la base de datos.*/
    @Transient
    private int contadorTemporal;
}

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@JoinColumn: Especifica la columna de la clave foránea en la relación entre entidades.*/
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

