package com.kodlamaio.hrms.core.adapters.mernis;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.requests.jobseekerRequests.CreateJobSeekerRequest;
import com.kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import com.kodlamaio.hrms.core.utilities.messages.Message;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

//@Service
public class MernisServiceAdapter implements UserCheckService {
	@Override
	public Result checkIfRealCustomer(CreateJobSeekerRequest jobSeeker) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		try {
			boolean result = client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalNumber()),
					jobSeeker.getFirstName().toUpperCase(), jobSeeker.getLastName().toUpperCase(),
					Integer.parseInt(jobSeeker.getYearOfBirth()));
			if (!result) {
				return new ErrorResult(Message.mernisVerification);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SuccessResult();
	}

}
