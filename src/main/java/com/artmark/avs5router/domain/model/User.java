package com.artmark.avs5router.domain.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 * Пользователь приложения
 *
 * @author V.Skorykh
 * @since 03.07.2014 17:15
 */
@Entity
@Table(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements UserDetails, Identity {

	/**
	 * Роль "Агент". Позволяет продавать билеты через веб-интерфейс.
	 */
	public static final String ROLE_AGENT = "ROLE_AGENT";

	/**
	 * Роль "Удаленный агент". Позволяет продавать билеты через веб-сервис по протоколу SOAP.
	 * Предоставляет доступ к отчетам о проданных билетах через веб-интерфейс.
	 */
	public static final String ROLE_SOAP = "ROLE_SOAP";

	/**
	 * Роль "Поставщик". Позволяет смотреть отчеты о проданных билетах
	 */
	public static final String ROLE_PROVIDER = "ROLE_PROVIDER";

	/**
	 * Роль "Менеджер". Позволяет просматривать отчеты.
	 */
	public static final String ROLE_MANAGER = "ROLE_MANAGER";

	/**
	 * Роль "Администратор". Предоставляет доступ к администрированию приложения.
	 */
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	@Id
	private Long id;

	/**
	 * Имя пользователя
	 */
	@NotBlank
	@Length(max = 32)
	protected String username;

	/**
	 * Пароль
	 */
	@NotBlank
	@Length(min = 6, max = 32)
	@XmlTransient
	private String password;

	/**
	 * Фамилия пользователя
	 */
	@NotBlank
	@Length(max = 32)
	@Column(name = "last_name")
	protected String lastName;

	/**
	 * Имя пользователя
	 */
	@NotBlank
	@Length(max = 32)
	@Column(name = "first_name")
	protected String firstName;

	/**
	 * Отчество пользователя
	 */
	@Length(max = 32)
	@Column(name = "middle_name")
	@XmlTransient
	private String middleName;

	/**
	 * Контактный телефон
	 */
	@Length(max = 32)
	@XmlTransient
	private String phone;

	/**
	 * Электронный адрес
	 */
	@Email
	@XmlTransient
	private String email;

	/**
	 * Временная зона, в которой работает пользователь
	 * @since 1.1
	 */
	@XmlTransient
	private String timezone;

	/**
	 * Дата создания записи
	 * @since 1.3
	 */
	@XmlTransient
	private Date created = new Date();

	/**
	 * Дата блокировки доступа к продаже. Если null - Доступ не заблокирован.
	 * @since 1.3
	 */
	@XmlTransient
	private boolean blocked;

	/**
	 * Список ролей пользователя
	 */
	@NotBlank
	@Length(max = 128)
	@XmlTransient
	private String roles = ROLE_AGENT;


	/**
	 * Статус записи
	 */
	@NotBlank
	@XmlTransient
	private String status;

	/**
	 * Дата начала актуальности
	 */
	@XmlTransient
	@Column(name = "date_from")
	private Date actualityFrom;

	/**
	 * Ссылка на пользователя который последний раз редактировал запись
	 */
	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "changed_by")
	private User changedBy;

	/**
	 * Авторизационные данные
	 */
	@Transient
	@XmlTransient
	private List<SimpleGrantedAuthority> authorities;

	private List<SimpleGrantedAuthority> parseAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		if (!StringUtils.isEmpty(roles)) {
			StringTokenizer st = new StringTokenizer(roles, ",");
			while (st.hasMoreTokens()) {
				String roleName = st.nextToken().trim();
                if (roleName.startsWith("ROLE_")) {
                    roleName = roleName.substring(5);
                }
				authorities.add(new SimpleGrantedAuthority(roleName));
			}
		}
		return authorities;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return "A".equals(status);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = parseAuthorities();
        }
		return authorities;
	}


	public boolean inRole(String... roleNames) {
		for (GrantedAuthority authority : getAuthorities()) {
			for (String roleName : roleNames) {
				if (authority.getAuthority().equalsIgnoreCase(roleName)) {
					return true;
				}
			}
		}
		return false;
	}

	public Date getActualityFrom() {
		return actualityFrom;
	}

	public void setActualityFrom(Date actualityFrom) {
		this.actualityFrom = actualityFrom;
	}

	public User getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
