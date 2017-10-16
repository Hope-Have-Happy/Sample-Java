/*
 * This code was generated by AWS Flow Framework Annotation Processor.
 * Refer to Amazon Simple Workflow Service documentation at http://aws.amazon.com/documentation/swf 
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
 package com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry;

import com.amazonaws.services.simpleworkflow.flow.core.AndPromise;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.core.Task;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowSelfClientBase;
import com.amazonaws.services.simpleworkflow.flow.generic.ContinueAsNewWorkflowExecutionParameters;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClient;

public class CronWithRetryWorkflowSelfClientImpl extends WorkflowSelfClientBase implements CronWithRetryWorkflowSelfClient {

    public CronWithRetryWorkflowSelfClientImpl() {
        this(null, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public CronWithRetryWorkflowSelfClientImpl(GenericWorkflowClient genericClient) {
        this(genericClient, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public CronWithRetryWorkflowSelfClientImpl(GenericWorkflowClient genericClient, 
            DataConverter dataConverter, StartWorkflowOptions schedulingOptions) {
            
        super(genericClient, dataConverter, schedulingOptions);
    }

    @Override
    public final void startCron(com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry.CronWithRetryWorkflowOptions options) { 
        startCronImpl(Promise.asPromise(options), (StartWorkflowOptions)null);
    }

    @Override
    public final void startCron(com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry.CronWithRetryWorkflowOptions options, Promise<?>... waitFor) { 
        startCronImpl(Promise.asPromise(options), (StartWorkflowOptions)null, waitFor);
    }
    
    @Override
    public final void startCron(com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry.CronWithRetryWorkflowOptions options, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        startCronImpl(Promise.asPromise(options), optionsOverride, waitFor);
    }
    
    @Override
    public final void startCron(Promise<com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry.CronWithRetryWorkflowOptions> options) {
        startCronImpl(options, (StartWorkflowOptions)null);
    }

    @Override
    public final void startCron(Promise<com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry.CronWithRetryWorkflowOptions> options, Promise<?>... waitFor) {
        startCronImpl(options, (StartWorkflowOptions)null, waitFor);
    }

    @Override
    public final void startCron(Promise<com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry.CronWithRetryWorkflowOptions> options, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        startCronImpl(options, optionsOverride, waitFor);
    }
    
    protected void startCronImpl(final Promise<com.amazonaws.services.simpleworkflow.flow.examples.cronwithretry.CronWithRetryWorkflowOptions> options, final StartWorkflowOptions schedulingOptionsOverride, Promise<?>... waitFor) {
        new Task(new Promise[] { options, new AndPromise(waitFor) }) {
    		@Override
			protected void doExecute() throws Throwable {
                ContinueAsNewWorkflowExecutionParameters _parameters_ = new ContinueAsNewWorkflowExecutionParameters();
                Object[] _input_ = new Object[1];
                _input_[0] = options.get();
                String _stringInput_ = dataConverter.toData(_input_);
				_parameters_.setInput(_stringInput_);
				_parameters_ = _parameters_.createContinueAsNewParametersFromOptions(schedulingOptions, schedulingOptionsOverride);
                
                if (genericClient == null) {
                    genericClient = decisionContextProvider.getDecisionContext().getWorkflowClient();
                }
                genericClient.continueAsNewOnCompletion(_parameters_);
			}
		};
    }
}