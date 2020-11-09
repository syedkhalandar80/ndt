package restApi.model;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import restApi.framework.entityConstants.BaseEntityJsonFieldConstant;
import restApi.framework.entityConstants.PersonEntityJsonFieldConstant;
import restApi.framework.validators.ValidList;
import restApi.framework.validators.ValidMap;

/**
 * This class defines the CouchBase document entity structure for Person.
 * 
 * @author Deval Bibodi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ PersonEntityJsonFieldConstant.ID, PersonEntityJsonFieldConstant.JANRAINID,
		PersonEntityJsonFieldConstant.FIRST_NAME, PersonEntityJsonFieldConstant.LAST_NAME,
		PersonEntityJsonFieldConstant.EMAIL, BaseEntityJsonFieldConstant.CREATE_TIME,
		BaseEntityJsonFieldConstant.LAST_MODIFIED_TIME, PersonEntityJsonFieldConstant.REGISTRATION_CODE,
		BaseEntityJsonFieldConstant.INSTANCE, PersonEntityJsonFieldConstant.PERSON_TYPES,
		PersonEntityJsonFieldConstant.ATTRIBUTES })
@Document
@TypeAlias(PersonEntityJsonFieldConstant.RESOURCE_TYPE_PERSON)
public class Person extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7230541548118810699L;

	/**
	 * Document Id for Person document.
	 */
	@Id
	@Field(PersonEntityJsonFieldConstant.ID)
	@NotNull(message = "person.id.notNullBlank")
	@NotBlank(message = "person.id.notNullBlank")
	private String id;

	/**
	 * Janrain id of person.
	 */
	@Field(PersonEntityJsonFieldConstant.JANRAINID)
	@NotNull(message = "person.janrainId.notNullBlank")
	@NotBlank(message = "person.janrainId.notNullBlank")
	private String janrainId;

	/**
	 * Registration code of person.
	 */
	@Field(PersonEntityJsonFieldConstant.REGISTRATION_CODE)
	@NotNull(message = "person.registrationCode.notNullBlank")
	@NotBlank(message = "person.registrationCode.notNullBlank")
	private String registrationCode;

	/**
	 * Attributes of person.
	 */
	@Field(PersonEntityJsonFieldConstant.ATTRIBUTES)
	@ValidMap(message = "person.attributes.notNullBlank")
	private Map<String, Object> attributes;

	/**
	 * Person types.
	 */
	@Field(PersonEntityJsonFieldConstant.PERSON_TYPES)
	@ValidList(message = "person.personTypes.notNullBlank")
	private List<String> personTypes;

	/**
	 * First name field to store First name of Person.
	 */
	@Field(PersonEntityJsonFieldConstant.FIRST_NAME)
	@NotNull(message = "person.firstName.notNullBlank")
	@NotBlank(message = "person.firstName.notNullBlank")
	private String firstName;

	/**
	 * Last name field to store Last name of Person.
	 */
	@Field(PersonEntityJsonFieldConstant.LAST_NAME)
	private String lastName;

	/**
	 * Email field to store email address of Person.
	 */
	@Field(PersonEntityJsonFieldConstant.EMAIL)
	@Email(message = "person.email.invalid")
	private String email;

	/** The marketo id. */
	@Field(PersonEntityJsonFieldConstant.MARKET_TO_ID)
	@JsonIgnore
	private String marketoId;

	/** The user token. */
	@Field(PersonEntityJsonFieldConstant.USER_TOKEN)
	@JsonIgnore
	private String userToken;

	/** The quit date. */
	@Field(PersonEntityJsonFieldConstant.QUIT_DATE)
	@JsonIgnore
	private String quitDate;

	/** The password. */
	@Field(PersonEntityJsonFieldConstant.PASSWORD)
	@JsonIgnore
	private String password;
	
	/** The password. */
	@Field(PersonEntityJsonFieldConstant.SOURCE)
	private String source;

	/**
	 * Last name field to store Last name of Person.
	 */
	@Field(PersonEntityJsonFieldConstant.GENDER)
	private String gender;
	
	@Field(PersonEntityJsonFieldConstant.UTC_OFFSET)
	private String utcOffset;
	
	@Field(PersonEntityJsonFieldConstant.PHOTO_PROFILE_LINK)
	private String photoProfileLink;
	
	
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
	 * @param password
	 *            the new password
	 */
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	/** The user token. */
	@Field(PersonEntityJsonFieldConstant.FORGOT_PASSWORD_TOKEN)
	@JsonIgnore
	private String forgotPasswordToken;

	/** The user token. */
	@Field(PersonEntityJsonFieldConstant.FORGOT_PASSWORD_TIMESTAMP)
	@JsonIgnore
	private Long forgotPasswordTimestamp;
	
	/** The user token. */
	@Field(PersonEntityJsonFieldConstant.AUTH_TOKEN)
	@JsonIgnore
	private String authToken;

	/** The user token. */
	@Field(PersonEntityJsonFieldConstant.AUTH_TOKEN_TIMESTAMP)
	@JsonIgnore
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
	 * @param id
	 *            - Long id of Person.
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
	 * @param firstName
	 *            - String first name.
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
	 * @param lastName
	 *            - String last name of Person.
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
	 * @param email
	 *            - String email address of Person.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method for Janrainid of person.
	 * 
	 * @return String- Janrain id of person.
	 */
	public String getJanrainId() {
		return janrainId;
	}

	/**
	 * Setter method for Janrainid of person.
	 * 
	 * @param janrainId
	 *            - janrain id.
	 */
	public void setJanrainId(String janrainId) {
		this.janrainId = janrainId;
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
	 * @param registrationCode
	 *            - String registration code.
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
	 * @param attributes
	 *            - person attributes.
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
		return personTypes;
	}

	/**
	 * Setter method for person types.
	 * 
	 * @param personTypes
	 *            - person types.
	 */
	public void setPersonTypes(List<String> personTypes) {
		this.personTypes = personTypes;
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
	 * @param marketoId
	 *            the new marketo id
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
	 * @param userToken
	 *            the new user token
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
	 * @param quitDate
	 *            the new quit date
	 */
	public void setQuitDate(String quitDate) {
		this.quitDate = quitDate;
	}

	/**
	 * Gets the forgot password token.
	 *
	 * @param forgotPasswordToken
	 *            the 32bit string token
	 */
	public String getForgotPasswordToken() {
		return forgotPasswordToken;
	}

	/**
	 * Sets the forgot password token.
	 *
	 * @param forgotPasswordToken
	 *            the 32 bit string token
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

	public static final String SOURCE_FACEBOOK = "Facebook";
	
	public static final String SOURCE_JANRAIN = "Janrain";

	public static final String SOURCE_LOCAL = "Local";
	
}
