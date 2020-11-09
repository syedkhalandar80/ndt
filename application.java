package restApi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import restApi.framework.convertor.String2MapConvertor;
import restApi.framework.entityConstants.BaseEntityJsonFieldConstant;
import restApi.framework.entityConstants.PersonEntityJsonFieldConstant;
import restApi.framework.validators.ValidMap;

/**
 * This class defines the CouchBase document entity structure for Person.
 * 
 * @author Deval Bibodi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ PersonEntityJsonFieldConstant.ID, PersonEntityJsonFieldConstant.FIRST_NAME,
		PersonEntityJsonFieldConstant.LAST_NAME, PersonEntityJsonFieldConstant.EMAIL,
		BaseEntityJsonFieldConstant.CREATE_TIME, BaseEntityJsonFieldConstant.LAST_MODIFIED_TIME,
		PersonEntityJsonFieldConstant.REGISTRATION_CODE, BaseEntityJsonFieldConstant.INSTANCE,
		PersonEntityJsonFieldConstant.PERSON_TYPES, PersonEntityJsonFieldConstant.ATTRIBUTES })
@TypeAlias(PersonEntityJsonFieldConstant.RESOURCE_TYPE_PERSON)
@TypeDefs({ @TypeDef(name = "JsonbType", typeClass = JsonBinaryType.class),
		@TypeDef(name = "StringArray", typeClass = StringArrayType.class) })

@Entity
@Table(name = "person")
public class Person extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7230541548118810699L;

	/**
	 * Document Id for Person document.
	 */
	@Id
	@JsonProperty(PersonEntityJsonFieldConstant.ID)
	@NotNull(message = "person.id.notNullBlank")
	@NotBlank(message = "person.id.notNullBlank")
	@Column(name = "id")
	private String id;

	/**
	 * Registration code of person.
	 */
	@JsonProperty(PersonEntityJsonFieldConstant.REGISTRATION_CODE)
	@NotNull(message = "person.registrationCode.notNullBlank")
	@NotBlank(message = "person.registrationCode.notNullBlank")
	@Column(name = "registration_code")
	private String registrationCode;

	/**
	 * Attributes of person.
	 */
	@JsonProperty(PersonEntityJsonFieldConstant.ATTRIBUTES)
	//@ValidMap(message = "person.attributes.notNullBlank")
	@Column(name = "attribute", columnDefinition = "jsonb")
	@Type(type = "JsonbType")
	@JsonDeserialize(converter = String2MapConvertor.class)
	private Map<String, Object> attributes;

	/**
	 * Person types.
	 */
	@JsonProperty(PersonEntityJsonFieldConstant.PERSON_TYPES)
	@NotNull(message = "person.personTypes.notNullBlank")
	@Column(name = "person_type", columnDefinition = "varchar[]")
	@Type(type = "StringArray")
	private String[] personTypes;

	/**
	 * First name field to store First name of Person.
	 */
	@JsonProperty(PersonEntityJsonFieldConstant.FIRST_NAME)
	@NotNull(message = "person.firstName.notNullBlank")
	@NotBlank(message = "person.firstName.notNullBlank")
	@Column(name = "first_name")
	private String firstName;

	/**
	 * Last name field to store Last name of Person.
	 */
	@JsonProperty(PersonEntityJsonFieldConstant.LAST_NAME)
	@Column(name = "last_name")
	private String lastName;

	/**
	 * Email field to store email address of Person.
	 */
	@JsonProperty(PersonEntityJsonFieldConstant.EMAIL)
	@Email(message = "person.email.invalid")
	@Column(name = "email")
	private String email;

	/** The marketo id. */
	@JsonProperty(PersonEntityJsonFieldConstant.MARKET_TO_ID)
	@JsonIgnore
	@Column(name = "marketo_id")
	private String marketoId;

	/** The user token. */
	@JsonProperty(PersonEntityJsonFieldConstant.USER_TOKEN)
	@JsonIgnore
	@Column(name = "user_token")
	private String userToken;

	/** The quit date. */
	@JsonProperty(PersonEntityJsonFieldConstant.QUIT_DATE)
	@JsonIgnore
	@Column(name = "quit_date")
	private String quitDate;

	/** The password. */
	@JsonProperty(PersonEntityJsonFieldConstant.PASSWORD)
	@JsonIgnore
	@Column(name = "password")
	private String password;

	/** The password. */
	@JsonProperty(PersonEntityJsonFieldConstant.SOURCE)
	@Column(name = "source")
	private String source;

	/**
	 * Last name field to store Last name of Person.
	 */
	@JsonProperty(PersonEntityJsonFieldConstant.GENDER)
	@Column(name = "gender")
	private String gender;

	@JsonProperty(PersonEntityJsonFieldConstant.UTC_OFFSET)
	@Column(name = "utc_offset")
	private String utcOffset;

	@JsonProperty(PersonEntityJsonFieldConstant.PHOTO_PROFILE_LINK)
	@Column(name = "photo_profile_link")
	private String photoProfileLink;
	
	/** Joining the Asset table column "person". */
	@OneToMany (mappedBy="userid",fetch = FetchType.LAZY, orphanRemoval= true)
	@JsonIgnore
	private List<Asset> assets=new ArrayList<>();
	
	/** Joining the Event table column "person_details". */
	@OneToMany (mappedBy="userid",fetch = FetchType.LAZY, orphanRemoval= true)
	@JsonIgnore 
	private List<Event> events=new ArrayList<>();

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	/** The user token. */
	@JsonProperty(PersonEntityJsonFieldConstant.FORGOT_PASSWORD_TOKEN)
	@JsonIgnore
	@Column(name = "forgot_password_token")
	private String forgotPasswordToken;

	/** The user token. */
	@JsonProperty(PersonEntityJsonFieldConstant.FORGOT_PASSWORD_TIMESTAMP)
	@JsonIgnore
	@Column(name = "forgot_password_timestamp")
	private Long forgotPasswordTimestamp;

	/** The user token. */
	@JsonProperty(PersonEntityJsonFieldConstant.AUTH_TOKEN)
	@JsonIgnore
	@Column(name = "auth_token")
	private String authToken;

	/** The user token. */
	@JsonProperty(PersonEntityJsonFieldConstant.AUTH_TOKEN_TIMESTAMP)
	@JsonIgnore
	@Column(name = "auth_token_timestamp")
	private Long authTokenTimestamp;

	/**
	 * Getter method for id of Person.
	 * 
	 * @return Long - person document id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter method for id of Person.
	 * 
	 * @param id - Long id of Person.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter method for first name of Person.
	 * 
	 * @return String - first name of Person.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for first name of Person.
	 * 
	 * @param firstName - String first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter method for last name of Person.
	 * 
	 * @return String - Person last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method for last name of Person.
	 * 
	 * @param lastName - String last name of Person.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter method for email address of Person.
	 * 
	 * @return String - email address of Person.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email address of Person.
	 * 
	 * @param email - String email address of Person.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method for registration code of person.
	 * 
	 * @return String - registration code of person.
	 */
	public String getRegistrationCode() {
		return registrationCode;
	}

	/**
	 * Setter method for registration code of person.
	 * 
	 * @param registrationCode - String registration code.
	 */
	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	/**
	 * Getter method for attributes of person.
	 * 
	 * @return String - person attributes.
	 */
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	/**
	 * Setter method for attributes of person.
	 * 
	 * @param attributes - person attributes.
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	/**
	 * Getter method for person type.
	 * 
	 * @return List<String> - person types.
	 */
	public List<String> getPersonTypes() {
		return Arrays.asList(personTypes);
	}

	/**
	 * Setter method for person types.
	 * 
	 * @param personTypes - person types.
	 */
	public void setPersonTypes(List<String> personTypes) {
		this.personTypes = personTypes.toArray(new String[personTypes.size()]);
	}

	/**
	 * Gets the marketo id.
	 *
	 * @return the marketo id
	 */
	public String getMarketoId() {
		return marketoId;
	}

	/**
	 * Sets the marketo id.
	 *
	 * @param marketoId the new marketo id
	 */
	public void setMarketoId(String marketoId) {
		this.marketoId = marketoId;
	}

	/**
	 * Gets the user token.
	 *
	 * @return the user token
	 */
	public String getUserToken() {
		return userToken;
	}

	/**
	 * Sets the user token.
	 *
	 * @param userToken the new user token
	 */
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	/**
	 * Gets the quit date.
	 *
	 * @return the quit date
	 */
	public String getQuitDate() {
		return quitDate;
	}

	/**
	 * Sets the quit date.
	 *
	 * @param quitDate the new quit date
	 */
	public void setQuitDate(String quitDate) {
		this.quitDate = quitDate;
	}

	/**
	 * Gets the forgot password token.
	 *
	 * @param forgotPasswordToken the 32bit string token
	 */
	public String getForgotPasswordToken() {
		return forgotPasswordToken;
	}

	/**
	 * Sets the forgot password token.
	 *
	 * @param forgotPasswordToken the 32 bit string token
	 */
	public void setForgotPasswordToken(String forgotPasswordToken) {
		this.forgotPasswordToken = forgotPasswordToken;
	}

	/**
	 * Sets the forgot password token created time in millis.
	 *
	 * @param forgotPasswordTimestamp
	 */
	public Long getForgotPasswordTimestamp() {
		return forgotPasswordTimestamp;
	}

	/**
	 * Sets the forgot password token created time in millis.
	 *
	 * @param forgotPasswordTimestamp
	 */
	public void setForgotPasswordTimestamp(Long forgotPasswordTimestamp) {
		this.forgotPasswordTimestamp = forgotPasswordTimestamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(String utcOffset) {
		this.utcOffset = utcOffset;
	}

	public String getPhotoProfileLink() {
		return photoProfileLink;
	}

	public void setPhotoProfileLink(String photoProfileLink) {
		this.photoProfileLink = photoProfileLink;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	
	public static final String SOURCE_FACEBOOK = "Facebook";
	public static final String SOURCE_GOOGLE = "Google";
	public static final String SOURCE_AWS_COGNITO = "AWS Cognito";
	public static final String SOURCE_JANRAIN = "Janrain";

	public static final String SOURCE_LOCAL = "Local";

}
