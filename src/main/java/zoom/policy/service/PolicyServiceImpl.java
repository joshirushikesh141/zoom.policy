package zoom.policy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoom.policy.entity.Policy;
import zoom.policy.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyRepository policyRepository;
	
	@Override
	public Policy issuePolicyforExporter(int exporterCode) {
		Policy policy = new Policy();
		policy.setExporterCode(exporterCode);
		return policyRepository.save(policy);
	}

	@Override
	public Policy getPolicyByPolicyNo(int policyNumber) {
		return policyRepository.findById(policyNumber).orElseThrow(()-> new IllegalArgumentException("Please provied correct policy number!!"));
	}

}
