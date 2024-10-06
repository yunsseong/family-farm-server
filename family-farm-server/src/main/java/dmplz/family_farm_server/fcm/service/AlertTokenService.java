package dmplz.family_farm_server.fcm.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dmplz.family_farm_server.fcm.dto.RegisterAlertToken;
import dmplz.family_farm_server.fcm.model.AlertToken;
import dmplz.family_farm_server.fcm.repository.AlertTokenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlertTokenService {

	private final AlertTokenRepository alertTokenRepository;

	public AlertToken getAlertToken(Long id) {
		return alertTokenRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
	}

	public AlertToken createAlertToken(RegisterAlertToken registerAlertToken) {
		return alertTokenRepository.save(new AlertToken(registerAlertToken));
	}
}
