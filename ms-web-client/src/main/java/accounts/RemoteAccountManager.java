package accounts;

import common.money.Percentage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rewards.internal.account.Account;

/**
 * An implementation of AccountManager that fetches account information from a
 * microservice. Only the first two methods are implemented to keep the lab
 * shorter.
 */
public class RemoteAccountManager implements AccountManager {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	/**
	 * Create an instance.
	 * 
	 * @param serviceUrl
	 *            The URL needed to access the microservice using REST.
	 */
	public RemoteAccountManager(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public String getInfo() {
		// Implementation info for debugging purposes
		return "remote";
	}

	@Override
	public List<Account> getAllAccounts() {
		Account[] accounts = restTemplate.getForObject(
				serviceUrl + "/accounts", Account[].class);
		return Arrays.asList(accounts);
	}

	@Override
	public Account getAccount(Long id) {
		return restTemplate.getForObject(serviceUrl + "/accounts/{id}",
				Account.class, id);
	}

	// Ignore the remaining methods to keep lab shorter.

	@Override
	public Account save(Account account) {
		// DO NOT MODIFY THIS CODE
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Account account) {
		// DO NOT MODIFY THIS CODE
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateBeneficiaryAllocationPercentages(Long accountId,
			Map<String, Percentage> allocationPercentages) {
		// DO NOT MODIFY THIS CODE
		throw new UnsupportedOperationException();
	}

	@Override
	public void addBeneficiary(Long accountId, String beneficiaryName) {
		// DO NOT MODIFY THIS CODE
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeBeneficiary(Long accountId, String beneficiaryName,
			Map<String, Percentage> allocationPercentages) {
		// DO NOT MODIFY THIS CODE
		throw new UnsupportedOperationException();
	}

}
