package zoom.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoom.policy.entity.Policy;
import zoom.policy.proxy.ExporterFeignClient;
import zoom.policy.proxy.dto.Exporter;
import zoom.policy.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	ExporterFeignClient ExporterFeignClient;
	
	@Autowired
	PolicyService policyService;
	
	@PostMapping("/issue/{exporterCode}")
	public String issuePolicyforExporter(@PathVariable int exporterCode) {
		try {
			Exporter exporter = ExporterFeignClient.getExporterByExporterCode(exporterCode);
			System.err.println("cross service data: "+exporter);
			Policy policyIssued = policyService.issuePolicyforExporter(exporterCode);
			return "Policy has been issued for the exporter: "+exporter.getExporterName()+" having policy number: "+policyIssued.getPolicyNumber();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured while issuing policy");
		}
	}
	
	@GetMapping("/getPolicy/{policyNumber}")
	public Policy getPolicyByPolicyNo(@PathVariable int policyNumber) {
		return policyService.getPolicyByPolicyNo(policyNumber);
	}

}
