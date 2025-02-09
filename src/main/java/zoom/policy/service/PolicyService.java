package zoom.policy.service;

import zoom.policy.entity.Policy;

public interface PolicyService {

	Policy issuePolicyforExporter(int exporterCode);

	Policy getPolicyByPolicyNo(int policyNumber);

}
