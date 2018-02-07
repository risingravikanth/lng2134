package com.lnganalysis.constants;

public interface ApplicationConstants {
	public static final String NO_DATA="nodata";
	public static final String DELETE_FAILED="deletefailed";
	public static final String DELETED="deleted";
	public static final String SAVED="saved";
	public static final String SAVE_FAILED="savefailed";
	
	public static final String EMAIL_REQUIRED="emailrequired";
	public static final String PWD_REQUIRED="pwdrequired";
	
	public static final String LOGIN_FAIL="loginfail";
	
	
	public static final String APP_EXCEPTION="appexception";
	
	public static final String SUCCESS="success";
	public static final String FAIL="fail";
	
	public static final String UPDATE_FAILED="updatefailed";
	public static final String UPDATED="updated";
	
	public static final String USER_NOT_EXISTS="usernotexists";
	public static final String USER_EXISTS="userexists";
	
	public static final String LOGIN_RES="loginresponse";
	public static final String CHNG_PWD_RESPONSE="changepwdresponse";
	public static final String RESET_PWD_RES="resetpwdresponse";
	
	public static final String CURR_PWD_NOT_MATCH="currentpwdnotmatch";
	public static final String PWDS_NOT_MATCH="pwdsnotmatch";
	public static final String CURR_PWD_REQUIRED="currentpwdrequired";
	public static final String NEW_PWD_REQUIRED="newpwdrequired";
	public static final String REENTER_PWD_REQUIRED="reenterpwdrequired";
	
	public static final String DATA_VALIDATION_FAIL="datavalidationfail";
	public static final String INCORRECT_DATA="incorrectdata";
	
	public static final String SESSION_EXPIRED="sessionexpired";
	public static final String USER="user";
	
	public static final String MAIL_TO_ADMIN_BODY="Hi,\n\n Below user is blocked. Please reset the Password.\n\n User ID:";
	public static final String MAIL_TO_USER_BODY1="Hi,\n\n Password Reset has done for User ID:";
	public static final String MAIL_TO_USER_BODY2=".Below is the reset the Password.\n\n New Password:";
	
	public static final String EXPLORATION_COUNT="explorationCount";
	public static final String REFINERY_COUNT="refineryCount";
	public static final String CRUDEOIL_COUNT="crudeoilCount";
	public static final String NATURALGAS_COUNT="naturalGasCount";
	public static final String LNG_COUNT="lngCount";
	public static final String STORAGE_COUNT="storageCount";
	public static final String PIPELINE_COUNT="pipelineCount";
	public static final String SMALLSCALELNG_COUNT="smallScaleLngCount";
	
	public static final String INVALID_DATA_SHEET="invalidDataSheet";
	public static final String YES="Y";
	public static final String NO="N";
	public static final String DEFAULT_PASSWORD="Pass1234";
	public static final String EXCEL_FILE_FORMAT_DATE_TIME="dd-M-yyyy_hhmmss";
	public static final String DUPLICATE_ENTRY="duplicate";
	public static final String APP_PROPERTIES="applicationProperties.properties";
	
	public static final String ONSHORE="onshore";
	public static final String OFFSHORE="offshore";
	public static final String LIQUEFACTION="Liquefaction";
	public static final String REGASIFICATION="Regasification";
	public static final String RECORD_ALREADY_EXISTS="Record Already Exists";
	
	//-------Excel Sheet column Constants Start-----------------------------------
	
	public static final String COLUMN_HEADER_REGION="Region";
	public static final String COLUMN_HEADER_COUNTRY="Country";
	public static final String EXPORT_COLUMN_HEADER_COUNTRY="ExportCountry";
	public static final String IMPORT_COLUMN_HEADER_COUNTRY="ImportCountry";
	public static final String COLUMN_HEADER_ONSHORE_OR_OFFSHORE="Onshore/OffShore";
	public static final String COLUMN_HEADER_STATUS="Status";
	public static final String COLUMN_HEADER_OPERATOR="Operator";
	public static final String COLUMN_HEADER_EQUITY_PARTNERS="Equity Partners";
	public static final String COLUMN_HEADER_COMPANYNAME="Company Name";
	
	public static final String COLUMN_HEADER_TYPE="Type";
	public static final String COLUMN_HEADER_CURRENT_OPERATOR="Current Operator";
	public static final String COLUMN_HEADER_CURRENT_EQUITY_PARTNERS="Current Equity Partners";
	public static final String COLUMN_HEADER_CURRENT_EQUITY_STAKES="CurrentEquityStakes";
	public static final String COLUMN_HEADER_HISTORIC_OPERATOR="Historic Operator";
	public static final String COLUMN_HEADER_HISTORIC_EQUITY_PARTNERS="Historic Equity Partners";
	
	public static final String COLUMN_HEADER_CURRENT_OWNERS="Current Owners";
	public static final String COLUMN_HEADER_CURRENT_OWNERSHIP="CurrentOwnerShip";
	public static final String COLUMN_HEADER_HISTORIC_OWNERS= "Historic Owners";
	
	public static final String COLUMN_HEADER_EQUITY_STAKES="EquityStakes";
	
//	Refinery Specific Columns
	
	public static final String COLUMN_HEADER_ALKYLATION_CAPACITY_UNIT="Alkylation Capacity Unit";
	public static final String COLUMN_HEADER_AROMATICS_CAPACITY_UNIT="Aromatics Capacity Unit";
	public static final String COLUMN_HEADER_POLMERIZATION_CAPACITY_UNIT="Polymerization Capacity Unit";
	public static final String COLUMN_HEADER_LUBES_CAPACITY_UNIT="Lubes Capacity Unit";
	public static final String COLUMN_HEADER_OXYGENATES_CAPACITY_UNIT="Oxygenates Capacity Unit";
	public static final String COLUMN_HEADER_COKE_CAPACITY_UNIT="Coke Capacity Unit";
	public static final String COLUMN_HEADER_SULPHUR_CAPACITY_UNIT="Sulphur Capacity Unit";
	public static final String COLUMN_HEADER_HYDROGEN_CAPACITY_UNIT="Hydrogen Capacity Unit";
	public static final String COLUMN_HEADER_ASPHALT_CAPACITY_UNIT="Asphalt Capacity Unit";
	
	// Storage specific Columns
	
	public static final String COLUMN_HEADER_PRODUCTS_STORED="Products Stored";
	public static final String COLUMN_HEADER_MODE_OF_ACCESS="Mode of Access";
	
	// Lng specific Columns
	
	public static final String COLUMN_HEADER_FEED_DETAILS="FEED Details";
	public static final String COLUMN_HEADER_FID_DETAILS="FID Details";
	public static final String COLUMN_HEADER_CONSTRUCTION_STATUS_DETAILS="Construction Status Details";
	public static final String COLUMN_HEADER_TECHNOLOGY_DETAILS="Technology Details";
	public static final String COLUMN_HEADER_ADDITIONAL_PRODUCTS="Additional Products";
	public static final String COLUMN_HEADER_ADDITIONAL_PRODUCTS_PRODUCTION_UNIT="Additional Products Production Unit";
	public static final String COLUMN_HEADER_FEED_OR_INPUT_TYPE="Feed/Input Type";
	public static final String COLUMN_HEADER_DISTRIBUTION_OR_OUTPUT_TYPE= "Distribution/Output Type";
	public static final String COLUMN_HEADER_UNITS="Units";
	
	// PipeLine Specific Columns
	public static final String COLUMN_HEADER_COMMODITY="Commodity";
	public static final String COLUMN_HEADER_START_COUNTRY="Start Country";
	public static final String COLUMN_HEADER_START_REGION="Start Region";
	public static final String COLUMN_HEADER_END_COUNTRY="End Country";
	public static final String COLUMN_HEADER_END_REGION="End Region";
	public static final String COLUMN_HEADER_PIPELINE_TYPE="Pipeline Type";
	public static final String COLUMN_HEADER_PARENT_CHILD_RELATION="Parent Child Relation";
	public static final String COLUMN_HEADER_LENGTH="Length";
	public static final String PARENT="P";
	public static final String CHILD="C";
	
	//Production Company Oil Gas
	public static final String CRUDEOIL="Crude Oil";
	public static final String NATURALGAS="Natural Gas";
	
	//SmallScaleLng 
	
	public static final String COLUMN_HEADER_TECHNOLOGY="Technology";
	public static final String COLUMN_HEADER_COMPANY="Company";
	public static final String COLUMN_HEADER_TECHNOLOGY_PROVIDER_COMPANY="Technology Provider Company";
	public static final String COLUMN_HEADER_LIQUEFACATION_UNIT="Liquefaction Capacity Unit";
	public static final String COLUMN_HEADER_REGASIFICATION_UNIT="Regasification Capacity Unit";
	public static final String COLUMN_HEADER_BUNKERING_UNIT="Bunkering Capacity Unit";
	public static final String COLUMN_HEADER_DISTRIBUTIONTYPE="Distribution Type";
	
	
	//--------- Excel Sheet column Constants End----------------
			
}
