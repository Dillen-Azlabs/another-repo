package sg.ihh.ms.sdms.app.rest.validator;

import sg.ihh.ms.sdms.app.rest.model.request.MDStaffDemographicRequest;

public class MDStaffDemographicValidator extends BaseValidator{

    public MDStaffDemographicValidator() {
    }
    public boolean validate(MDStaffDemographicRequest request) {
        return notNull(request)
                && validate(request.getFirstName())
                && validate(request.getLastName())
                && validate(request.getSalutation())
                && validate(request.getOtherId())
                && validate(request.getFormattedName());
    }

    public boolean validate(String providerId,MDStaffDemographicRequest request) {
        return notNull(request)
                && validate(providerId)
                && validate(request.getFirstName())
                && validate(request.getLastName())
                && validate(request.getSalutation())
                && validate(request.getOtherId())
                && validate(request.getFormattedName());
    }

}
