package cl.generation.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

/*
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
*/
public class Objeto {
	/*
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	*/

}
