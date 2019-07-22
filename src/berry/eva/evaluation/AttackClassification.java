package berry.eva.evaluation;

public enum AttackClassification {

	Injection, 
	BrokenAuthentication, 
	SensitiveDataExposure, 
	XMLExternalEntities,
	BrokenAccessControl,
	SecurityMisconfiguration,
	XSS,
	InsecureDeserialization,
	UsingComponentsWithKnownVulnerabilities,
	InsufficientLoggingMonitoring
}
