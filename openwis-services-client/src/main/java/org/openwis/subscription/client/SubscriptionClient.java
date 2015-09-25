package org.openwis.subscription.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Client for CacheIndex web service.
 *
 * @author Jose García
 */
public class SubscriptionClient extends WebServiceGatewaySupport {
    /**
     * Retrieves the last processed request.
     *
     * @param subscriptionId
     * @return
     */
    public ProcessedRequest retrieveLastProcessedRequest(long subscriptionId) {
        ObjectFactory objFact = new ObjectFactory();

        FindLastProcessedRequest request =  objFact.createFindLastProcessedRequest();
        request.setSubscriptionId(subscriptionId);

        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createFindLastProcessedRequest(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        FindLastProcessedRequestResponse responseType = (FindLastProcessedRequestResponse) response.getValue();

        return responseType.getReturn();
    }

    /**
     * Retrieves a subscription by the identifier.
     *
     * @param subscriptionId
     * @return
     */
    public Subscription retrieveSubscription(long subscriptionId) {
       ObjectFactory objFact = new ObjectFactory();

        GetSubscription request =  objFact.createGetSubscription();
        request.setSubscriptionId(subscriptionId);


        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createGetSubscription(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        GetSubscriptionResponse responseType = (GetSubscriptionResponse) response.getValue();

        return responseType.getReturn();
    }

    /**
     * Retreives the paginated subscriptions by users.
     *
     * @param firstResult
     * @param maxResults
     * @param sort
     * @return
     */
    public List<Subscription> retrieveSubscriptionsByUsers(int firstResult, int maxResults, SortDirection sort) {
        ObjectFactory objFact = new ObjectFactory();

        GetSubscriptionsByUsers request =  objFact.createGetSubscriptionsByUsers();
        request.setFirstResult(firstResult);
        request.setMaxResults(maxResults);
        request.setSortDirection(sort);


        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createGetSubscriptionsByUsers(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        GetSubscriptionsByUsersResponse responseType = (GetSubscriptionsByUsersResponse) response.getValue();

        return responseType.getReturn();
    }


    // TODO: Check to implement (getSubscriptionsByUsersCount) if required and clarify parameters
    public int retrieveSubscriptionsByUsersCount() {

        return -1;
    }


    /**
     * Creates a metadata subscription.
     *
     * @param metadataUrn
     * @param subscription
     * @return  Subscription id.
     */
    public Long createSubscription(String metadataUrn, Subscription subscription) {
        ObjectFactory objFact = new ObjectFactory();

        CreateSubscription request =  objFact.createCreateSubscription();
        request.setMetadataUrn(metadataUrn);
        request.setSubscription(subscription);

        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createCreateSubscription(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        CreateSubscriptionResponse responseType = (CreateSubscriptionResponse) response.getValue();

        return responseType.getReturn();
    }


    /**
     * Deletes a subscription.
     *
     * @param subscriptionId    Subscription identifier.
     */
    public void deleteSubscription(Long subscriptionId) {
        ObjectFactory objFact = new ObjectFactory();

        DeleteSubscription request =  objFact.createDeleteSubscription();
        request.setSubscriptionId(subscriptionId);

        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createDeleteSubscription(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        DeleteSubscriptionResponse responseType = (DeleteSubscriptionResponse) response.getValue();
    }

    /**
     * Updates a subscription.
     *
     * @param subscription
     * @return
     */
    public Subscription updateSubscription(Subscription subscription) {
        ObjectFactory objFact = new ObjectFactory();

        UpdateSubscription request =  objFact.createUpdateSubscription();
        request.setSubscription(subscription);

        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createUpdateSubscription(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        UpdateSubscriptionResponse responseType = (UpdateSubscriptionResponse) response.getValue();

        return responseType.getReturn();
    }

    /**
     * Updates a subscription config.
     *
     * @param subscriptionId
     * @param frequency
     * @param primaryDissemination
     * @param secondaryDissemination
     * @param startingDate
     * @return
     */
    public Subscription updateSubscriptionConfig(Long subscriptionId,
                                                 Frequency frequency,
                                                 Dissemination primaryDissemination,
                                                 Dissemination secondaryDissemination,
                                                 String startingDate) {
        ObjectFactory objFact = new ObjectFactory();

        UpdateSubscriptionConfig request =  objFact.createUpdateSubscriptionConfig();
        request.setSubscriptionId(subscriptionId);
        request.setFrequency(frequency);
        request.setPrimaryDissemination(primaryDissemination);
        request.setSecondaryDissemination(secondaryDissemination);
        request.setStartingDate(startingDate);

        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createUpdateSubscriptionConfig(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        UpdateSubscriptionConfigResponse responseType = (UpdateSubscriptionConfigResponse) response.getValue();

        return responseType.getReturn();
    }



    /**
     * Resumes a subscription.
     *
     * @param subscriptionId    Subscription identifier.
     */
    public void resumeSubscription(Long subscriptionId) {
        ObjectFactory objFact = new ObjectFactory();

        ResumeSubscription request =  objFact.createResumeSubscription();
        request.setSubscription(subscriptionId);


        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createResumeSubscription(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        ResumeSubscriptionResponse responseType = (ResumeSubscriptionResponse) response.getValue();
    }


    /**
     * Suspends a subscription.
     *
     * @param subscriptionId    Subscription identifier.
     */
    public void suspendSubscription(Long subscriptionId) {
        ObjectFactory objFact = new ObjectFactory();

        SuspendSubscription request =  objFact.createSuspendSubscription();
        request.setSubscription(subscriptionId);

        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createSuspendSubscription(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        SuspendSubscriptionResponse responseType = (SuspendSubscriptionResponse) response.getValue();
    }

    /**
     * Sets a subscription.
     *
     * @param activateBackup
     */
    public void setBackup(boolean activateBackup, String dateFrom, String deploymentName) {
        ObjectFactory objFact = new ObjectFactory();

        SetBackup request =  objFact.createSetBackup();
        request.setActivateBackup(activateBackup);
        request.setDateFrom(dateFrom);
        request.setDeploymentName(deploymentName);

        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createSetBackup(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        SetBackupResponse responseType = (SetBackupResponse) response.getValue();
    }


    /**
     * Checks a user subscription.
     *
     * @param user
     */
    public void checkUserSubscription(String user) {
        ObjectFactory objFact = new ObjectFactory();

        CheckUserSubscription request =  objFact.createCheckUserSubscription();
        request.setUser(user);


        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(
                objFact.createCheckUserSubscription(request),
                new SoapActionCallback(
                        "http://localhost:8088/mockProductMetadataServiceSoapBinding"));
        CheckUserSubscriptionResponse responseType = (CheckUserSubscriptionResponse) response.getValue();
    }

    /**
     * Checks a user subscription.
     *
     * @param user
     */
    // TODO: Check to implement if required and clarify parameters
    public void checkUsersSubscription(String user) {

    }
}