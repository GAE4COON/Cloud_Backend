package com.gae4coon.cloudmaestro.domain.resource.service;

import com.gae4coon.cloudmaestro.domain.ssohost.dto.GroupData;
import com.gae4coon.cloudmaestro.domain.ssohost.dto.NodeData;
import com.gae4coon.cloudmaestro.domain.ssohost.service.DiagramDTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddResourceService {
    private final DiagramDTOService diagramDTOService;

    // Group
    public GroupData addAWSCloudLogo(){
        return GroupData.builder()
                .isGroup(true)
                .key("AWS Cloud Logo")
                .text("AWS Cloud Logo")
                .type("AWS_Groups")
                .stroke("rgb(0,0,0)")
                .build();
    }

    public GroupData addAWSCloud(){
        return GroupData.builder()
                .isGroup(true)
                .key("AWS Cloud")
                .text("AWS Cloud")
                .type("AWS_Groups")
                .stroke("rgb(0,0,0)")
                .build();
    }

    public GroupData addIoTGreengrassGroup(){
        return GroupData.builder()
                .isGroup(true)
                .key("IoT Greengrass")
                .text("IoT Greengrass")
                .type("AWS_Groups")
                .stroke("rgb(122,161,22)")
                .build();
    }

    public GroupData addIoTGreengrassDeployment(){
        return GroupData.builder()
                .isGroup(true)
                .key("IoT Greengrass Deployment")
                .text("IoT Greengrass Deployment")
                .type("AWS_Groups")
                .stroke("rgb(122,161,22)")
                .build();
    }

    public GroupData addStepFuctionsworkflow(){
        return GroupData.builder()
                .isGroup(true)
                .key("Step Fuctions workflow")
                .text("Step Fuctions workflow")
                .type("AWS_Groups")
                .stroke("rgb(231,21,123)")
                .build();
    }

    public GroupData addCorporatedatacenter(){
        return GroupData.builder()
                .isGroup(true)
                .key("Corporate data center")
                .text("Corporate data center")
                .type("AWS_Groups")
                .stroke("rgb(125,137,152)")
                .build();
    }

    public GroupData addEC2instacecontents(){
        return GroupData.builder()
                .isGroup(true)
                .key("EC2 instace contents")
                .text("EC2 instace contents")
                .type("AWS_Groups")
                .stroke("rgb(237,113,0)")
                .build();
    }

    public GroupData addElaticBeanstalkcontainer(){
        return GroupData.builder()
                .isGroup(true)
                .key("Elatic Beanstalk container")
                .text("Elatic Beanstalk container")
                .type("AWS_Groups")
                .stroke("rgb(237,113,0)")
                .build();
    }

    public GroupData addPrivatesubnet(){
        return GroupData.builder()
                .isGroup(true)
                .key("Private subnet")
                .text("Private subnet")
                .type("AWS_Groups")
                .stroke("rgb(0,164,166)")
                .build();
    }

    public GroupData addPublicsubnet(){
        return GroupData.builder()
                .isGroup(true)
                .key("Public subnet")
                .text("Public subnet")
                .type("AWS_Groups")
                .stroke("rgb(122,161,22)")
                .build();
    }

    public GroupData addRegion(){
        return GroupData.builder()
                .isGroup(true)
                .key("Region")
                .text("Region")
                .type("AWS_Groups")
                .stroke("rgb(0,164,166)")
                .build();
    }

    public GroupData addAvailabilityZone(){
        return GroupData.builder()
                .isGroup(true)
                .key("Availability Zone")
                .text("Availability Zone")
                .type("AWS_Groups")
                .stroke("rgb(0,164,166)")
                .build();
    }

    public GroupData addSecurityGroup(){
        return GroupData.builder()
                .isGroup(true)
                .key("Security Group")
                .text("Security Group")
                .type("AWS_Groups")
                .stroke("rgb(221,52,76)")
                .build();
    }

    public GroupData addServercontents(){
        return GroupData.builder()
                .isGroup(true)
                .key("Server contents")
                .text("Server contents")
                .type("AWS_Groups")
                .stroke("rgb(125,137,152)")
                .build();
    }

    public GroupData addSpotFleet(){
        return GroupData.builder()
                .isGroup(true)
                .key("Spot Fleet")
                .text("Spot Fleet")
                .type("AWS_Groups")
                .stroke("rgb(237,113,0)")
                .build();
    }

    public GroupData addAutoScalinggroup(){
        return GroupData.builder()
                .isGroup(true)
                .key("Auto Scaling group")
                .text("Auto Scaling group")
                .type("AWS_Groups")
                .stroke("rgb(237,113,0)")
                .build();
    }

    public GroupData addVPC(){
        return GroupData.builder()
                .isGroup(true)
                .key("VPC")
                .text("VPC")
                .type("AWS_Groups")
                .stroke("rgb(140,79,255)")
                .build();
    }

    public GroupData addService(){
        return GroupData.builder()
                .isGroup(true)
                .key("Service")
                .text("Service")
                .type("AWS_Groups")
                .stroke("rgb(150,150,150)")
                .build();
    }

    public GroupData addEC2Group(){
        return GroupData.builder()
                .isGroup(true)
                .key("EC2Group")
                .text("EC2Group")
                .type("AWS_Groups")
                .stroke("rgb(150,100,150)")
                .build();
    }
    public NodeData addAntiDDoS(){
        return NodeData.builder()
                .key("Anti DDoS")
                .text("Anti DDoS")
                .source("/img/Network_icon/Anti_DDoS.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addAP(){
        return NodeData.builder()
                .key("AP")
                .text("AP")
                .source("/img/Network_icon/AP.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addDatabase(){
        return NodeData.builder()
                .key("Database")
                .text("Database")
                .source("/img/Network_icon/database.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addFirewall(){
        return NodeData.builder()
                .key("Firewall")
                .text("Firewall")
                .source("/img/Network_icon/firewall.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addHub(){
        return NodeData.builder()
                .key("Hub")
                .text("Hub")
                .source("/img/Network_icon/hub.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addIPS(){
        return NodeData.builder()
                .key("IPS")
                .text("IPS")
                .source("/img/Network_icon/ips.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addL2_switch(){
        return NodeData.builder()
                .key("L2_switch")
                .text("L2_switch")
                .source("/img/Network_icon/L2_switch.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addL3_switch(){
        return NodeData.builder()
                .key("L3_switch")
                .text("L3_switch")
                .source("/img/Network_icon/L3_switch.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addL4_switch(){
        return NodeData.builder()
                .key("L4_switch")
                .text("L4_switch")
                .source("/img/Network_icon/L4_switch.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addL7_switch(){
        return NodeData.builder()
                .key("L7_switch")
                .text("L7_switch")
                .source("/img/Network_icon/L7_switch.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addNetwork(){
        return NodeData.builder()
                .key("Network")
                .text("Network")
                .source("/img/Network_icon/network.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addPC(){
        return NodeData.builder()
                .key("PC")
                .text("PC")
                .source("/img/Network_icon/PC.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addRouter(){
        return NodeData.builder()
                .key("Router")
                .text("Router")
                .source("/img/Network_icon/router.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addServer(){
        return NodeData.builder()
                .key("Server")
                .text("Server")
                .source("/img/Network_icon/server.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addNetwork_WAF(){
        return NodeData.builder()
                .key("Network_WAF")
                .text("Network_WAF")
                .source("/img/Network_icon/WAF.png")
                .type("Network_icon")
                .build();
    }

    public NodeData addAthena(){
        return NodeData.builder()
                .key("Athena")
                .text("Athena")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Athena_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addCloudSearch(){
        return NodeData.builder()
                .key("CloudSearch")
                .text("CloudSearch")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-CloudSearch_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addDataZone(){
        return NodeData.builder()
                .key("DataZone")
                .text("DataZone")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-DataZone_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addEMR(){
        return NodeData.builder()
                .key("EMR")
                .text("EMR")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-EMR_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addFinSpace(){
        return NodeData.builder()
                .key("FinSpace")
                .text("FinSpace")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-FinSpace_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addKinesisDataAnalytics(){
        return NodeData.builder()
                .key("Kinesis Data Analytics")
                .text("Kinesis Data Analytics")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Kinesis-Data-Analytics_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addKinesisDataFirehose(){
        return NodeData.builder()
                .key("Kinesis Data Firehose")
                .text("Kinesis Data Firehose")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Kinesis-Data-Firehose_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addKinesisDataStreams(){
        return NodeData.builder()
                .key("Kinesis Data Streams")
                .text("Kinesis Data Streams")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Kinesis-Data-Streams_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addAnalytics_KinesisVideoStreams(){
        return NodeData.builder()
                .key("Analytics_Kinesis Video Streams")
                .text("Analytics_Kinesis Video Streams")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Kinesis-Video-Streams_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addKinesis(){
        return NodeData.builder()
                .key("Kinesis")
                .text("Kinesis")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Kinesis_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addManagedStreamingforApacheKafka(){
        return NodeData.builder()
                .key("Managed Streaming for Apache Kafka")
                .text("Managed Streaming for Apache Kafka")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Managed-Streaming-for-Apache-Kafka_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchService(){
        return NodeData.builder()
                .key("OpenSearch Service")
                .text("OpenSearch Service")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-OpenSearch-Service_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addQuickSight(){
        return NodeData.builder()
                .key("QuickSight")
                .text("QuickSight")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-QuickSight_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshift(){
        return NodeData.builder()
                .key("Redshift")
                .text("Redshift")
                .source("/img/AWS_icon/Arch_Analytics/Arch_Amazon-Redshift_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addCleanRooms(){
        return NodeData.builder()
                .key("Clean Rooms")
                .text("Clean Rooms")
                .source("/img/AWS_icon/Arch_Analytics/Arch_AWS-Clean-Rooms_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addDataExchange(){
        return NodeData.builder()
                .key("Data Exchange")
                .text("Data Exchange")
                .source("/img/AWS_icon/Arch_Analytics/Arch_AWS-Data-Exchange_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addDataPipeline(){
        return NodeData.builder()
                .key("Data Pipeline")
                .text("Data Pipeline")
                .source("/img/AWS_icon/Arch_Analytics/Arch_AWS-Data-Pipeline_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addGlueDataBrew(){
        return NodeData.builder()
                .key("Glue DataBrew")
                .text("Glue DataBrew")
                .source("/img/AWS_icon/Arch_Analytics/Arch_AWS-Glue-DataBrew_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addGlueElasticViews(){
        return NodeData.builder()
                .key("Glue Elastic Views")
                .text("Glue Elastic Views")
                .source("/img/AWS_icon/Arch_Analytics/Arch_AWS-Glue-Elastic-Views_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addGlue(){
        return NodeData.builder()
                .key("Glue")
                .text("Glue")
                .source("/img/AWS_icon/Arch_Analytics/Arch_AWS-Glue_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addLakeFormation(){
        return NodeData.builder()
                .key("Lake Formation")
                .text("Lake Formation")
                .source("/img/AWS_icon/Arch_Analytics/Arch_AWS-Lake-Formation_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addAPIGateway(){
        return NodeData.builder()
                .key("API Gateway")
                .text("API Gateway")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_Amazon-API-Gateway_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addAppFlow(){
        return NodeData.builder()
                .key("AppFlow")
                .text("AppFlow")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_Amazon-AppFlow_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridge(){
        return NodeData.builder()
                .key("EventBridge")
                .text("EventBridge")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_Amazon-EventBridge_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addManagedWorkflowsforApacheAirflow(){
        return NodeData.builder()
                .key("Managed Workflows for Apache Airflow")
                .text("Managed Workflows for Apache Airflow")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_Amazon-Managed-Workflows-for-Apache-Airflow_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addMQ(){
        return NodeData.builder()
                .key("MQ")
                .text("MQ")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_Amazon-MQ_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addSimpleNotificationService(){
        return NodeData.builder()
                .key("Simple Notification Service")
                .text("Simple Notification Service")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_Amazon-Simple-Notification-Service_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addSimpleQueueService(){
        return NodeData.builder()
                .key("Simple Queue Service")
                .text("Simple Queue Service")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_Amazon-Simple-Queue-Service_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addAppSync(){
        return NodeData.builder()
                .key("AppSync")
                .text("AppSync")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_AWS-AppSync_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addConsoleMobileApplication(){
        return NodeData.builder()
                .key("Console Mobile Application")
                .text("Console Mobile Application")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_AWS-Console-Mobile-Application_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addExpressWorkflows(){
        return NodeData.builder()
                .key("Express Workflows")
                .text("Express Workflows")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_AWS-Express-Workflows_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addStepFunctions(){
        return NodeData.builder()
                .key("Step Functions")
                .text("Step Functions")
                .source("/img/AWS_icon/Arch_App-Integration/Arch_AWS-Step-Functions_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addManagedBlockchain(){
        return NodeData.builder()
                .key("Managed Blockchain")
                .text("Managed Blockchain")
                .source("/img/AWS_icon/Arch_Blockchain/Arch_Amazon-Managed-Blockchain_48.svg")
                .type("Blockchain")
                .build();
    }

    public NodeData addQuantumLedgerDatabase(){
        return NodeData.builder()
                .key("Quantum Ledger Database")
                .text("Quantum Ledger Database")
                .source("/img/AWS_icon/Arch_Blockchain/Arch_Amazon-Quantum-Ledger-Database_48.svg")
                .type("Blockchain")
                .build();
    }

    public NodeData addAlexaForBusiness(){
        return NodeData.builder()
                .key("Alexa For Business")
                .text("Alexa For Business")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Alexa-For-Business_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addChimeSDK(){
        return NodeData.builder()
                .key("Chime SDK")
                .text("Chime SDK")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-Chime-SDK_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addChime(){
        return NodeData.builder()
                .key("Chime")
                .text("Chime")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-Chime_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addConnect(){
        return NodeData.builder()
                .key("Connect")
                .text("Connect")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-Connect_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addHoneycode(){
        return NodeData.builder()
                .key("Honeycode")
                .text("Honeycode")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-Honeycode_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addPinpointAPIs(){
        return NodeData.builder()
                .key("Pinpoint APIs")
                .text("Pinpoint APIs")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-Pinpoint-APIs_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addPinpoint(){
        return NodeData.builder()
                .key("Pinpoint")
                .text("Pinpoint")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-Pinpoint_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addSimpleEmailService(){
        return NodeData.builder()
                .key("Simple Email Service")
                .text("Simple Email Service")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-Simple-Email-Service_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addWorkDocsSDK(){
        return NodeData.builder()
                .key("WorkDocs SDK")
                .text("WorkDocs SDK")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-WorkDocs-SDK_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addWorkDocs(){
        return NodeData.builder()
                .key("WorkDocs")
                .text("WorkDocs")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-WorkDocs_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addWorkMail(){
        return NodeData.builder()
                .key("WorkMail")
                .text("WorkMail")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_Amazon-WorkMail_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addSupplyChain(){
        return NodeData.builder()
                .key("Supply Chain")
                .text("Supply Chain")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_AWS-Supply-Chain_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addWickr(){
        return NodeData.builder()
                .key("Wickr")
                .text("Wickr")
                .source("/img/AWS_icon/Arch_Business-Applications/Arch_AWS-Wickr_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addApplicationCostProfiler(){
        return NodeData.builder()
                .key("Application Cost Profiler")
                .text("Application Cost Profiler")
                .source("/img/AWS_icon/Arch_Cloud-Financial-Management/Arch_AWS-Application-Cost-Profiler_48.svg")
                .type("Cloud-Financial-Management")
                .build();
    }

    public NodeData addBillingConductor(){
        return NodeData.builder()
                .key("Billing Conductor")
                .text("Billing Conductor")
                .source("/img/AWS_icon/Arch_Cloud-Financial-Management/Arch_AWS-Billing-Conductor_48.svg")
                .type("Cloud-Financial-Management")
                .build();
    }

    public NodeData addBudgets(){
        return NodeData.builder()
                .key("Budgets")
                .text("Budgets")
                .source("/img/AWS_icon/Arch_Cloud-Financial-Management/Arch_AWS-Budgets_48.svg")
                .type("Cloud-Financial-Management")
                .build();
    }

    public NodeData addCostandUsageReport(){
        return NodeData.builder()
                .key("Cost and Usage Report")
                .text("Cost and Usage Report")
                .source("/img/AWS_icon/Arch_Cloud-Financial-Management/Arch_AWS-Cost-and-Usage-Report_48.svg")
                .type("Cloud-Financial-Management")
                .build();
    }

    public NodeData addCostExplorer(){
        return NodeData.builder()
                .key("Cost Explorer")
                .text("Cost Explorer")
                .source("/img/AWS_icon/Arch_Cloud-Financial-Management/Arch_AWS-Cost-Explorer_48.svg")
                .type("Cloud-Financial-Management")
                .build();
    }

    public NodeData addReservedInstanceReporting(){
        return NodeData.builder()
                .key("Reserved Instance Reporting")
                .text("Reserved Instance Reporting")
                .source("/img/AWS_icon/Arch_Cloud-Financial-Management/Arch_Reserved-Instance-Reporting_48.svg")
                .type("Cloud-Financial-Management")
                .build();
    }

    public NodeData addSavingsPlans(){
        return NodeData.builder()
                .key("Savings Plans")
                .text("Savings Plans")
                .source("/img/AWS_icon/Arch_Cloud-Financial-Management/Arch_Savings-Plans_48.svg")
                .type("Cloud-Financial-Management")
                .build();
    }

    public NodeData addEC2AutoScaling(){
        return NodeData.builder()
                .key("EC2 Auto Scaling")
                .text("EC2 Auto Scaling")
                .source("/img/AWS_icon/Arch_Compute/Arch_Amazon-EC2-Auto-Scaling_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2ImageBuilder(){
        return NodeData.builder()
                .key("EC2 Image Builder")
                .text("EC2 Image Builder")
                .source("/img/AWS_icon/Arch_Compute/Arch_Amazon-EC2-Image-Builder_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2(){
        return NodeData.builder()
                .key("EC2")
                .text("EC2")
                .source("/img/AWS_icon/Arch_Compute/Arch_Amazon-EC2_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addGenomicsCLI(){
        return NodeData.builder()
                .key("Genomics CLI")
                .text("Genomics CLI")
                .source("/img/AWS_icon/Arch_Compute/Arch_Amazon-Genomics-CLI_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addLightsailforResearch(){
        return NodeData.builder()
                .key("Lightsail for Research")
                .text("Lightsail for Research")
                .source("/img/AWS_icon/Arch_Compute/Arch_Amazon-Lightsail-for-Research_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addLightsail(){
        return NodeData.builder()
                .key("Lightsail")
                .text("Lightsail")
                .source("/img/AWS_icon/Arch_Compute/Arch_Amazon-Lightsail_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addAppRunner(){
        return NodeData.builder()
                .key("App Runner")
                .text("App Runner")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-App-Runner_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addBatch(){
        return NodeData.builder()
                .key("Batch")
                .text("Batch")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Batch_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addComputeOptimizer(){
        return NodeData.builder()
                .key("Compute Optimizer")
                .text("Compute Optimizer")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Compute-Optimizer_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addElasticBeanstalk(){
        return NodeData.builder()
                .key("Elastic Beanstalk")
                .text("Elastic Beanstalk")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Elastic-Beanstalk_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addLambda(){
        return NodeData.builder()
                .key("Lambda")
                .text("Lambda")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Lambda_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addLocalZones(){
        return NodeData.builder()
                .key("Local Zones")
                .text("Local Zones")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Local-Zones_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addNitroEnclaves(){
        return NodeData.builder()
                .key("Nitro Enclaves")
                .text("Nitro Enclaves")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Nitro-Enclaves_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addOutpostsfamily(){
        return NodeData.builder()
                .key("Outposts family")
                .text("Outposts family")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Outposts-family_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addOutpostsrack(){
        return NodeData.builder()
                .key("Outposts rack")
                .text("Outposts rack")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Outposts-rack_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addOutpostsservers(){
        return NodeData.builder()
                .key("Outposts servers")
                .text("Outposts servers")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Outposts-servers_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addParallelCluster(){
        return NodeData.builder()
                .key("Parallel Cluster")
                .text("Parallel Cluster")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Parallel-Cluster_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addServerlessApplicationRepository(){
        return NodeData.builder()
                .key("Serverless Application Repository")
                .text("Serverless Application Repository")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Serverless-Application-Repository_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addSimSpaceWeaver(){
        return NodeData.builder()
                .key("SimSpace Weaver")
                .text("SimSpace Weaver")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-SimSpace-Weaver_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addThinkboxDeadline(){
        return NodeData.builder()
                .key("Thinkbox Deadline")
                .text("Thinkbox Deadline")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Thinkbox-Deadline_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addThinkboxFrost(){
        return NodeData.builder()
                .key("Thinkbox Frost")
                .text("Thinkbox Frost")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Thinkbox-Frost_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addThinkboxKrakatoa(){
        return NodeData.builder()
                .key("Thinkbox Krakatoa")
                .text("Thinkbox Krakatoa")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Thinkbox-Krakatoa_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addThinkboxSequoia(){
        return NodeData.builder()
                .key("Thinkbox Sequoia")
                .text("Thinkbox Sequoia")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Thinkbox-Sequoia_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addThinkboxStoke(){
        return NodeData.builder()
                .key("Thinkbox Stoke")
                .text("Thinkbox Stoke")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Thinkbox-Stoke_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addThinkboxXMesh(){
        return NodeData.builder()
                .key("Thinkbox XMesh")
                .text("Thinkbox XMesh")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Thinkbox-XMesh_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addWavelength(){
        return NodeData.builder()
                .key("Wavelength")
                .text("Wavelength")
                .source("/img/AWS_icon/Arch_Compute/Arch_AWS-Wavelength_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addBottlerocket(){
        return NodeData.builder()
                .key("Bottlerocket")
                .text("Bottlerocket")
                .source("/img/AWS_icon/Arch_Compute/Arch_Bottlerocket_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addElasticFabricAdapter(){
        return NodeData.builder()
                .key("Elastic Fabric Adapter")
                .text("Elastic Fabric Adapter")
                .source("/img/AWS_icon/Arch_Compute/Arch_Elastic-Fabric-Adapter_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addNICEDCV(){
        return NodeData.builder()
                .key("NICE DCV")
                .text("NICE DCV")
                .source("/img/AWS_icon/Arch_Compute/Arch_NICE-DCV_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addNICEEnginFrame(){
        return NodeData.builder()
                .key("NICE EnginFrame")
                .text("NICE EnginFrame")
                .source("/img/AWS_icon/Arch_Compute/Arch_NICE-EnginFrame_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addVMwareCloudon(){
        return NodeData.builder()
                .key("VMware Cloud on")
                .text("VMware Cloud on")
                .source("/img/AWS_icon/Arch_Compute/Arch_VMware-Cloud-on-AWS_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addECSAnywhere(){
        return NodeData.builder()
                .key("ECS Anywhere")
                .text("ECS Anywhere")
                .source("/img/AWS_icon/Arch_Containers/Arch_Amazon-ECS-Anywhere_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addEKSAnywhere(){
        return NodeData.builder()
                .key("EKS Anywhere")
                .text("EKS Anywhere")
                .source("/img/AWS_icon/Arch_Containers/Arch_Amazon-EKS-Anywhere_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addEKSCloud(){
        return NodeData.builder()
                .key("EKS Cloud")
                .text("EKS Cloud")
                .source("/img/AWS_icon/Arch_Containers/Arch_Amazon-EKS-Cloud_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addEKSDistro(){
        return NodeData.builder()
                .key("EKS Distro")
                .text("EKS Distro")
                .source("/img/AWS_icon/Arch_Containers/Arch_Amazon-EKS-Distro_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerRegistry(){
        return NodeData.builder()
                .key("Elastic Container Registry")
                .text("Elastic Container Registry")
                .source("/img/AWS_icon/Arch_Containers/Arch_Amazon-Elastic-Container-Registry_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerService(){
        return NodeData.builder()
                .key("Elastic Container Service")
                .text("Elastic Container Service")
                .source("/img/AWS_icon/Arch_Containers/Arch_Amazon-Elastic-Container-Service_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticKubernetesService(){
        return NodeData.builder()
                .key("Elastic Kubernetes Service")
                .text("Elastic Kubernetes Service")
                .source("/img/AWS_icon/Arch_Containers/Arch_Amazon-Elastic-Kubernetes-Service_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addFargate(){
        return NodeData.builder()
                .key("Fargate")
                .text("Fargate")
                .source("/img/AWS_icon/Arch_Containers/Arch_AWS-Fargate_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addRedHatOpenShiftServiceon(){
        return NodeData.builder()
                .key("Red Hat OpenShift Service on")
                .text("Red Hat OpenShift Service on")
                .source("/img/AWS_icon/Arch_Containers/Arch_Red-Hat-OpenShift-Service-on-AWS_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addActivate(){
        return NodeData.builder()
                .key("Activate")
                .text("Activate")
                .source("/img/AWS_icon/Arch_Customer-Enablement/Arch_AWS-Activate_48.svg")
                .type("Customer-Enablement")
                .build();
    }

    public NodeData addIQ(){
        return NodeData.builder()
                .key("IQ")
                .text("IQ")
                .source("/img/AWS_icon/Arch_Customer-Enablement/Arch_AWS-IQ_48.svg")
                .type("Customer-Enablement")
                .build();
    }

    public NodeData addManagedServices(){
        return NodeData.builder()
                .key("Managed Services")
                .text("Managed Services")
                .source("/img/AWS_icon/Arch_Customer-Enablement/Arch_AWS-Managed-Services_48.svg")
                .type("Customer-Enablement")
                .build();
    }

    public NodeData addProfessionalServices(){
        return NodeData.builder()
                .key("Professional Services")
                .text("Professional Services")
                .source("/img/AWS_icon/Arch_Customer-Enablement/Arch_AWS-Professional-Services_48.svg")
                .type("Customer-Enablement")
                .build();
    }

    public NodeData addrePost(){
        return NodeData.builder()
                .key("re Post")
                .text("re Post")
                .source("/img/AWS_icon/Arch_Customer-Enablement/Arch_AWS-re_Post_48.svg")
                .type("Customer-Enablement")
                .build();
    }

    public NodeData addSupport(){
        return NodeData.builder()
                .key("Support")
                .text("Support")
                .source("/img/AWS_icon/Arch_Customer-Enablement/Arch_AWS-Support_48.svg")
                .type("Customer-Enablement")
                .build();
    }

    public NodeData addTrainingCertification(){
        return NodeData.builder()
                .key("Training Certification")
                .text("Training Certification")
                .source("/img/AWS_icon/Arch_Customer-Enablement/Arch_AWS-Training-Certification_48.svg")
                .type("Customer-Enablement")
                .build();
    }

    public NodeData addAurora(){
        return NodeData.builder()
                .key("Aurora")
                .text("Aurora")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-Aurora_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDocumentDB(){
        return NodeData.builder()
                .key("DocumentDB")
                .text("DocumentDB")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-DocumentDB_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDB(){
        return NodeData.builder()
                .key("DynamoDB")
                .text("DynamoDB")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-DynamoDB_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addElastiCache(){
        return NodeData.builder()
                .key("ElastiCache")
                .text("ElastiCache")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-ElastiCache_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addKeyspaces(){
        return NodeData.builder()
                .key("Keyspaces")
                .text("Keyspaces")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-Keyspaces_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addMemoryDBforRedis(){
        return NodeData.builder()
                .key("MemoryDB for Redis")
                .text("MemoryDB for Redis")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-MemoryDB-for-Redis_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addNeptune(){
        return NodeData.builder()
                .key("Neptune")
                .text("Neptune")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-Neptune_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSonVMware(){
        return NodeData.builder()
                .key("RDS on VMware")
                .text("RDS on VMware")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-RDS-on-VMware_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDS(){
        return NodeData.builder()
                .key("RDS")
                .text("RDS")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-RDS_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addTimestream(){
        return NodeData.builder()
                .key("Timestream")
                .text("Timestream")
                .source("/img/AWS_icon/Arch_Database/Arch_Amazon-Timestream_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDatabaseMigrationService(){
        return NodeData.builder()
                .key("Database Migration Service")
                .text("Database Migration Service")
                .source("/img/AWS_icon/Arch_Database/Arch_AWS-Database-Migration-Service_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addCodeCatalyst(){
        return NodeData.builder()
                .key("CodeCatalyst")
                .text("CodeCatalyst")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_Amazon-CodeCatalyst_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCorretto(){
        return NodeData.builder()
                .key("Corretto")
                .text("Corretto")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_Amazon-Corretto_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addApplicationComposer(){
        return NodeData.builder()
                .key("Application Composer")
                .text("Application Composer")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-Application-Composer_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCloudControlAPI(){
        return NodeData.builder()
                .key("Cloud Control API")
                .text("Cloud Control API")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-Cloud-Control-API_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCloudDevelopmentKit(){
        return NodeData.builder()
                .key("Cloud Development Kit")
                .text("Cloud Development Kit")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-Cloud-Development-Kit_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCloud9(){
        return NodeData.builder()
                .key("Cloud9")
                .text("Cloud9")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-Cloud9_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCloudShell(){
        return NodeData.builder()
                .key("CloudShell")
                .text("CloudShell")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-CloudShell_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCodeArtifact(){
        return NodeData.builder()
                .key("CodeArtifact")
                .text("CodeArtifact")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-CodeArtifact_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCodeBuild(){
        return NodeData.builder()
                .key("CodeBuild")
                .text("CodeBuild")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-CodeBuild_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCodeCommit(){
        return NodeData.builder()
                .key("CodeCommit")
                .text("CodeCommit")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-CodeCommit_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCodeDeploy(){
        return NodeData.builder()
                .key("CodeDeploy")
                .text("CodeDeploy")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-CodeDeploy_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCodePipeline(){
        return NodeData.builder()
                .key("CodePipeline")
                .text("CodePipeline")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-CodePipeline_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCodeStar(){
        return NodeData.builder()
                .key("CodeStar")
                .text("CodeStar")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-CodeStar_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addCommandLineInterface(){
        return NodeData.builder()
                .key("Command Line Interface")
                .text("Command Line Interface")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-Command-Line-Interface_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addToolsandSDKs(){
        return NodeData.builder()
                .key("Tools and SDKs")
                .text("Tools and SDKs")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-Tools-and-SDKs_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addXRay(){
        return NodeData.builder()
                .key("X Ray")
                .text("X Ray")
                .source("/img/AWS_icon/Arch_Developer-Tools/Arch_AWS-X-Ray_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addAppStream(){
        return NodeData.builder()
                .key("AppStream")
                .text("AppStream")
                .source("/img/AWS_icon/Arch_End-User-Computing/Arch_Amazon-AppStream_48.svg")
                .type("End-User-Computing")
                .build();
    }

    public NodeData addWorkLink(){
        return NodeData.builder()
                .key("WorkLink")
                .text("WorkLink")
                .source("/img/AWS_icon/Arch_End-User-Computing/Arch_Amazon-WorkLink_48.svg")
                .type("End-User-Computing")
                .build();
    }

    public NodeData addWorkSpacesFamily(){
        return NodeData.builder()
                .key("WorkSpaces Family")
                .text("WorkSpaces Family")
                .source("/img/AWS_icon/Arch_End-User-Computing/Arch_Amazon-WorkSpaces-Family_48.svg")
                .type("End-User-Computing")
                .build();
    }

    public NodeData addLocationService(){
        return NodeData.builder()
                .key("Location Service")
                .text("Location Service")
                .source("/img/AWS_icon/Arch_Front-End-Web-Mobile/Arch_Amazon-Location-Service_48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addAmplify(){
        return NodeData.builder()
                .key("Amplify")
                .text("Amplify")
                .source("/img/AWS_icon/Arch_Front-End-Web-Mobile/Arch_AWS-Amplify_48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addDeviceFarm(){
        return NodeData.builder()
                .key("Device Farm")
                .text("Device Farm")
                .source("/img/AWS_icon/Arch_Front-End-Web-Mobile/Arch_AWS-Device-Farm_48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addGameLift(){
        return NodeData.builder()
                .key("GameLift")
                .text("GameLift")
                .source("/img/AWS_icon/Arch_Games/Arch_Amazon-GameLift_48.svg")
                .type("Games")
                .build();
    }

    public NodeData addGameSparks(){
        return NodeData.builder()
                .key("GameSparks")
                .text("GameSparks")
                .source("/img/AWS_icon/Arch_Games/Arch_Amazon-GameSparks_48.svg")
                .type("Games")
                .build();
    }

    public NodeData addGameKit(){
        return NodeData.builder()
                .key("GameKit")
                .text("GameKit")
                .source("/img/AWS_icon/Arch_Games/Arch_AWS-GameKit_48.svg")
                .type("Games")
                .build();
    }

    public NodeData addOpen3DEngine(){
        return NodeData.builder()
                .key("Open 3D Engine")
                .text("Open 3D Engine")
                .source("/img/AWS_icon/Arch_Games/Arch_Open-3D-Engine_48.svg")
                .type("Games")
                .build();
    }

    public NodeData addMarketplaceDark(){
        return NodeData.builder()
                .key("Marketplace Dark")
                .text("Marketplace Dark")
                .source("/img/AWS_icon/Arch_General-Icons/Arch_AWS-Marketplace_Dark_48.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addMarketplaceLight(){
        return NodeData.builder()
                .key("Marketplace Light")
                .text("Marketplace Light")
                .source("/img/AWS_icon/Arch_General-Icons/Arch_AWS-Marketplace_Light_48.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addIoT1Click(){
        return NodeData.builder()
                .key("IoT 1 Click")
                .text("IoT 1 Click")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-1-Click_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAnalytics(){
        return NodeData.builder()
                .key("IoT Analytics")
                .text("IoT Analytics")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Analytics_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTButton(){
        return NodeData.builder()
                .key("IoT Button")
                .text("IoT Button")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Button_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTCore(){
        return NodeData.builder()
                .key("IoT Core")
                .text("IoT Core")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Core_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTDeviceDefender(){
        return NodeData.builder()
                .key("IoT Device Defender")
                .text("IoT Device Defender")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Device-Defender_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTDeviceManagement(){
        return NodeData.builder()
                .key("IoT Device Management")
                .text("IoT Device Management")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Device-Management_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTEduKit(){
        return NodeData.builder()
                .key("IoT EduKit")
                .text("IoT EduKit")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-EduKit_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTEvents(){
        return NodeData.builder()
                .key("IoT Events")
                .text("IoT Events")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Events_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTExpressLink(){
        return NodeData.builder()
                .key("IoT ExpressLink")
                .text("IoT ExpressLink")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-ExpressLink_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTFleetWise(){
        return NodeData.builder()
                .key("IoT FleetWise")
                .text("IoT FleetWise")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-FleetWise_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrass(){
        return NodeData.builder()
                .key("IoT Greengrass")
                .text("IoT Greengrass")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Greengrass_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTRoboRunner(){
        return NodeData.builder()
                .key("IoT RoboRunner")
                .text("IoT RoboRunner")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-RoboRunner_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSiteWise(){
        return NodeData.builder()
                .key("IoT SiteWise")
                .text("IoT SiteWise")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-SiteWise_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingsGraph(){
        return NodeData.builder()
                .key("IoT Things Graph")
                .text("IoT Things Graph")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-Things-Graph_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTTwinMaker(){
        return NodeData.builder()
                .key("IoT TwinMaker")
                .text("IoT TwinMaker")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_AWS-IoT-TwinMaker_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addFreeRTOS(){
        return NodeData.builder()
                .key("FreeRTOS")
                .text("FreeRTOS")
                .source("/img/AWS_icon/Arch_Internet-of-Things/Arch_FreeRTOS_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addAugmentedAIA2I(){
        return NodeData.builder()
                .key("Augmented AI A2I")
                .text("Augmented AI A2I")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Augmented-AI-A2I_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addCodeGuru(){
        return NodeData.builder()
                .key("CodeGuru")
                .text("CodeGuru")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-CodeGuru_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addCodeWhisperer(){
        return NodeData.builder()
                .key("CodeWhisperer")
                .text("CodeWhisperer")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-CodeWhisperer_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addComprehendMedical(){
        return NodeData.builder()
                .key("Comprehend Medical")
                .text("Comprehend Medical")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Comprehend-Medical_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addComprehend(){
        return NodeData.builder()
                .key("Comprehend")
                .text("Comprehend")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Comprehend_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addDevOpsGuru(){
        return NodeData.builder()
                .key("DevOps Guru")
                .text("DevOps Guru")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-DevOps-Guru_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addElasticInference(){
        return NodeData.builder()
                .key("Elastic Inference")
                .text("Elastic Inference")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Elastic-Inference_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addForecast(){
        return NodeData.builder()
                .key("Forecast")
                .text("Forecast")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Forecast_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addFraudDetector(){
        return NodeData.builder()
                .key("Fraud Detector")
                .text("Fraud Detector")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Fraud-Detector_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addHealthLake(){
        return NodeData.builder()
                .key("HealthLake")
                .text("HealthLake")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-HealthLake_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addKendra(){
        return NodeData.builder()
                .key("Kendra")
                .text("Kendra")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Kendra_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addLex(){
        return NodeData.builder()
                .key("Lex")
                .text("Lex")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Lex_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addLookoutforEquipment(){
        return NodeData.builder()
                .key("Lookout for Equipment")
                .text("Lookout for Equipment")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Lookout-for-Equipment_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addLookoutforMetrics(){
        return NodeData.builder()
                .key("Lookout for Metrics")
                .text("Lookout for Metrics")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Lookout-for-Metrics_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addLookoutforVision(){
        return NodeData.builder()
                .key("Lookout for Vision")
                .text("Lookout for Vision")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Lookout-for-Vision_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addMonitron(){
        return NodeData.builder()
                .key("Monitron")
                .text("Monitron")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Monitron_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addOmics(){
        return NodeData.builder()
                .key("Omics")
                .text("Omics")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Omics_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addPersonalize(){
        return NodeData.builder()
                .key("Personalize")
                .text("Personalize")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Personalize_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addPolly(){
        return NodeData.builder()
                .key("Polly")
                .text("Polly")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Polly_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addRekognition(){
        return NodeData.builder()
                .key("Rekognition")
                .text("Rekognition")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Rekognition_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerGroundTruth(){
        return NodeData.builder()
                .key("SageMaker Ground Truth")
                .text("SageMaker Ground Truth")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-SageMaker-Ground-Truth_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerStudioLab(){
        return NodeData.builder()
                .key("SageMaker Studio Lab")
                .text("SageMaker Studio Lab")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-SageMaker-Studio-Lab_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMaker(){
        return NodeData.builder()
                .key("SageMaker")
                .text("SageMaker")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-SageMaker_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addTextract(){
        return NodeData.builder()
                .key("Textract")
                .text("Textract")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Textract_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addTranscribe(){
        return NodeData.builder()
                .key("Transcribe")
                .text("Transcribe")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Transcribe_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addTranslate(){
        return NodeData.builder()
                .key("Translate")
                .text("Translate")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Amazon-Translate_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addApacheMXNeton(){
        return NodeData.builder()
                .key("Apache MXNet on")
                .text("Apache MXNet on")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_Apache-MXNet-on-AWS_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addDeepLearningAMIs(){
        return NodeData.builder()
                .key("Deep Learning AMIs")
                .text("Deep Learning AMIs")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_AWS-Deep-Learning-AMIs_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addDeepLearningContainers(){
        return NodeData.builder()
                .key("Deep Learning Containers")
                .text("Deep Learning Containers")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_AWS-Deep-Learning-Containers_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addDeepComposer(){
        return NodeData.builder()
                .key("DeepComposer")
                .text("DeepComposer")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_AWS-DeepComposer_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addDeepLens(){
        return NodeData.builder()
                .key("DeepLens")
                .text("DeepLens")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_AWS-DeepLens_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addDeepRacer(){
        return NodeData.builder()
                .key("DeepRacer")
                .text("DeepRacer")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_AWS-DeepRacer_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addNeuron(){
        return NodeData.builder()
                .key("Neuron")
                .text("Neuron")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_AWS-Neuron_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addPanorama(){
        return NodeData.builder()
                .key("Panorama")
                .text("Panorama")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_AWS-Panorama_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addTensorFlowon(){
        return NodeData.builder()
                .key("TensorFlow on")
                .text("TensorFlow on")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_TensorFlow-on-AWS_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addTorchServe(){
        return NodeData.builder()
                .key("TorchServe")
                .text("TorchServe")
                .source("/img/AWS_icon/Arch_Machine-Learning/Arch_TorchServe_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addCloudWatch(){
        return NodeData.builder()
                .key("CloudWatch")
                .text("CloudWatch")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_Amazon-CloudWatch_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatch(List<NodeData> nodeDataList){
        return NodeData.builder()
                .key("CloudWatch "+diagramDTOService.getNodeNumber(nodeDataList, "CloudWatch"))
                .text("CloudWatch")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_Amazon-CloudWatch_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addManagedGrafana(){
        return NodeData.builder()
                .key("Managed Grafana")
                .text("Managed Grafana")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_Amazon-Managed-Grafana_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addManagedServiceforPrometheus(){
        return NodeData.builder()
                .key("Managed Service for Prometheus")
                .text("Managed Service for Prometheus")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_Amazon-Managed-Service-for-Prometheus_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addAppConfig(){
        return NodeData.builder()
                .key("AppConfig")
                .text("AppConfig")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-AppConfig_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addApplicationAutoScaling(){
        return NodeData.builder()
                .key("Application Auto Scaling")
                .text("Application Auto Scaling")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Application-Auto-Scaling_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addAutoScaling(){
        return NodeData.builder()
                .key("Auto Scaling")
                .text("Auto Scaling")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Auto-Scaling_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addBackintAgent(){
        return NodeData.builder()
                .key("Backint Agent")
                .text("Backint Agent")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Backint-Agent_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addChatbot(){
        return NodeData.builder()
                .key("Chatbot")
                .text("Chatbot")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Chatbot_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudFormation(){
        return NodeData.builder()
                .key("CloudFormation")
                .text("CloudFormation")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-CloudFormation_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudTrail(){
        return NodeData.builder()
                .key("CloudTrail")
                .text("CloudTrail")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-CloudTrail_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudTrail(List<NodeData> nodeDataList){
        return NodeData.builder()
                .key("CloudTrail "+diagramDTOService.getNodeNumber(nodeDataList, "CloudTrail"))
                .text("CloudTrail")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-CloudTrail_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addConfig(){
        return NodeData.builder()
                .key("Config")
                .text("Config")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Config_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addControlTower(){
        return NodeData.builder()
                .key("Control Tower")
                .text("Control Tower")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Control-Tower_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addDistroforOpenTelemetry(){
        return NodeData.builder()
                .key("Distro for OpenTelemetry")
                .text("Distro for OpenTelemetry")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Distro-for-OpenTelemetry_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addFaultInjectionSimulator(){
        return NodeData.builder()
                .key("Fault Injection Simulator")
                .text("Fault Injection Simulator")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Fault-Injection-Simulator_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addHealthDashboard(){
        return NodeData.builder()
                .key("Health Dashboard")
                .text("Health Dashboard")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Health-Dashboard_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addLaunchWizard(){
        return NodeData.builder()
                .key("Launch Wizard")
                .text("Launch Wizard")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Launch-Wizard_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addLicenseManager(){
        return NodeData.builder()
                .key("License Manager")
                .text("License Manager")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-License-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addManagementConsole(){
        return NodeData.builder()
                .key("Management Console")
                .text("Management Console")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Management-Console_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorks(){
        return NodeData.builder()
                .key("OpsWorks")
                .text("OpsWorks")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-OpsWorks_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOrganizations(){
        return NodeData.builder()
                .key("Organizations")
                .text("Organizations")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Organizations_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addProton(){
        return NodeData.builder()
                .key("Proton")
                .text("Proton")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Proton_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addResilienceHub(){
        return NodeData.builder()
                .key("Resilience Hub")
                .text("Resilience Hub")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Resilience-Hub_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addResourceExplorer(){
        return NodeData.builder()
                .key("Resource Explorer")
                .text("Resource Explorer")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Resource-Explorer_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addServiceCatalog(){
        return NodeData.builder()
                .key("Service Catalog")
                .text("Service Catalog")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Service-Catalog_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addServiceManagementConnector(){
        return NodeData.builder()
                .key("Service Management Connector")
                .text("Service Management Connector")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Service-Management-Connector_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManager(){
        return NodeData.builder()
                .key("Systems Manager")
                .text("Systems Manager")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Systems-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addTelcoNetworkBuilder(){
        return NodeData.builder()
                .key("Telco Network Builder")
                .text("Telco Network Builder")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Telco-Network-Builder_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addTrustedAdvisor(){
        return NodeData.builder()
                .key("Trusted Advisor")
                .text("Trusted Advisor")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Trusted-Advisor_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addWellitectedTool(){
        return NodeData.builder()
                .key("Well itected Tool")
                .text("Well itected Tool")
                .source("/img/AWS_icon/Arch_Management-Governance/Arch_AWS-Well-Architected-Tool_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addElasticTranscoder(){
        return NodeData.builder()
                .key("Elastic Transcoder")
                .text("Elastic Transcoder")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_Amazon-Elastic-Transcoder_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addInteractiveVideoService(){
        return NodeData.builder()
                .key("Interactive Video Service")
                .text("Interactive Video Service")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_Amazon-Interactive-Video-Service_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addMediaServices_KinesisVideoStreams(){
        return NodeData.builder()
                .key("Media-Services_Kinesis Video Streams")
                .text("Media-Services_Kinesis Video Streams")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_Amazon-Kinesis-Video-Streams_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addNimbleStudio(){
        return NodeData.builder()
                .key("Nimble Studio")
                .text("Nimble Studio")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_Amazon-Nimble-Studio_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalAppliancesSoftware(){
        return NodeData.builder()
                .key("Elemental Appliances & Software")
                .text("Elemental Appliances & Software")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-Appliances-&-Software_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalConductor(){
        return NodeData.builder()
                .key("Elemental Conductor")
                .text("Elemental Conductor")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-Conductor_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalDelta(){
        return NodeData.builder()
                .key("Elemental Delta")
                .text("Elemental Delta")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-Delta_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalLink(){
        return NodeData.builder()
                .key("Elemental Link")
                .text("Elemental Link")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-Link_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalLive(){
        return NodeData.builder()
                .key("Elemental Live")
                .text("Elemental Live")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-Live_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalMediaConnect(){
        return NodeData.builder()
                .key("Elemental MediaConnect")
                .text("Elemental MediaConnect")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-MediaConnect_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalMediaConvert(){
        return NodeData.builder()
                .key("Elemental MediaConvert")
                .text("Elemental MediaConvert")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-MediaConvert_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalMediaLive(){
        return NodeData.builder()
                .key("Elemental MediaLive")
                .text("Elemental MediaLive")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-MediaLive_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalMediaPackage(){
        return NodeData.builder()
                .key("Elemental MediaPackage")
                .text("Elemental MediaPackage")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-MediaPackage_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalMediaStore(){
        return NodeData.builder()
                .key("Elemental MediaStore")
                .text("Elemental MediaStore")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-MediaStore_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalMediaTailor(){
        return NodeData.builder()
                .key("Elemental MediaTailor")
                .text("Elemental MediaTailor")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-MediaTailor_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalServer(){
        return NodeData.builder()
                .key("Elemental Server")
                .text("Elemental Server")
                .source("/img/AWS_icon/Arch_Media-Services/Arch_AWS-Elemental-Server_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addApplicationDiscoveryService(){
        return NodeData.builder()
                .key("Application Discovery Service")
                .text("Application Discovery Service")
                .source("/img/AWS_icon/Arch_Migration-Transfer/Arch_AWS-Application-Discovery-Service_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addApplicationMigrationService(){
        return NodeData.builder()
                .key("Application Migration Service")
                .text("Application Migration Service")
                .source("/img/AWS_icon/Arch_Migration-Transfer/Arch_AWS-Application-Migration-Service_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addDataSync(){
        return NodeData.builder()
                .key("DataSync")
                .text("DataSync")
                .source("/img/AWS_icon/Arch_Migration-Transfer/Arch_AWS-DataSync_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMainframeModernization(){
        return NodeData.builder()
                .key("Mainframe Modernization")
                .text("Mainframe Modernization")
                .source("/img/AWS_icon/Arch_Migration-Transfer/Arch_AWS-Mainframe-Modernization_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMigrationEvaluator(){
        return NodeData.builder()
                .key("Migration Evaluator")
                .text("Migration Evaluator")
                .source("/img/AWS_icon/Arch_Migration-Transfer/Arch_AWS-Migration-Evaluator_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMigrationHub(){
        return NodeData.builder()
                .key("Migration Hub")
                .text("Migration Hub")
                .source("/img/AWS_icon/Arch_Migration-Transfer/Arch_AWS-Migration-Hub_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addTransferFamily(){
        return NodeData.builder()
                .key("Transfer Family")
                .text("Transfer Family")
                .source("/img/AWS_icon/Arch_Migration-Transfer/Arch_AWS-Transfer-Family_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addCloudFront(){
        return NodeData.builder()
                .key("CloudFront")
                .text("CloudFront")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_Amazon-CloudFront_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53(){
        return NodeData.builder()
                .key("Route 53")
                .text("Route 53")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_Amazon-Route-53_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addVirtualPrivateCloud(){
        return NodeData.builder()
                .key("Virtual Private Cloud")
                .text("Virtual Private Cloud")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_Amazon-Virtual-Private-Cloud_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addVPCLattice(){
        return NodeData.builder()
                .key("VPC Lattice")
                .text("VPC Lattice")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_Amazon-VPC-Lattice_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addAppMesh(){
        return NodeData.builder()
                .key("App Mesh")
                .text("App Mesh")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-App-Mesh_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addClientVPN(){
        return NodeData.builder()
                .key("Client VPN")
                .text("Client VPN")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Client-VPN_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudMap(){
        return NodeData.builder()
                .key("Cloud Map")
                .text("Cloud Map")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Cloud-Map_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudWAN(){
        return NodeData.builder()
                .key("Cloud WAN")
                .text("Cloud WAN")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Cloud-WAN_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addDirectConnect(){
        return NodeData.builder()
                .key("Direct Connect")
                .text("Direct Connect")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Direct-Connect_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addGlobalAccelerator(){
        return NodeData.builder()
                .key("Global Accelerator")
                .text("Global Accelerator")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Global-Accelerator_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addPrivate5G(){
        return NodeData.builder()
                .key("Private 5G")
                .text("Private 5G")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Private-5G_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addPrivateLink(){
        return NodeData.builder()
                .key("PrivateLink")
                .text("PrivateLink")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-PrivateLink_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addSitetoSiteVPN(){
        return NodeData.builder()
                .key("Site to Site VPN")
                .text("Site to Site VPN")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Site-to-Site-VPN_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addTransitGateway(){
        return NodeData.builder()
                .key("Transit Gateway")
                .text("Transit Gateway")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Transit-Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addVerifiedAccess(){
        return NodeData.builder()
                .key("Verified Access")
                .text("Verified Access")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_AWS-Verified-Access_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addElasticLoadBalancing(){
        return NodeData.builder()
                .key("Elastic Load Balancing")
                .text("Elastic Load Balancing")
                .source("/img/AWS_icon/Arch_Networking-Content-Delivery/Arch_Elastic-Load-Balancing_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addBraket(){
        return NodeData.builder()
                .key("Braket")
                .text("Braket")
                .source("/img/AWS_icon/Arch_Quantum-Technologies/Arch_Amazon-Braket_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addRoboMaker(){
        return NodeData.builder()
                .key("RoboMaker")
                .text("RoboMaker")
                .source("/img/AWS_icon/Arch_Robotics/Arch_AWS-RoboMaker_48.svg")
                .type("Robotics")
                .build();
    }

    public NodeData addGroundStation(){
        return NodeData.builder()
                .key("Ground Station")
                .text("Ground Station")
                .source("/img/AWS_icon/Arch_Satellite/Arch_AWS-Ground-Station_48.svg")
                .type("Satellite")
                .build();
    }

    public NodeData addCloudDirectory(){
        return NodeData.builder()
                .key("Cloud Directory")
                .text("Cloud Directory")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-Cloud-Directory_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addCognito(){
        return NodeData.builder()
                .key("Cognito")
                .text("Cognito")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-Cognito_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addDetective(){
        return NodeData.builder()
                .key("Detective")
                .text("Detective")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-Detective_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addGuardDuty(){
        return NodeData.builder()
                .key("GuardDuty")
                .text("GuardDuty")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-GuardDuty_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addInspector(){
        return NodeData.builder()
                .key("Inspector")
                .text("Inspector")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-Inspector_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addMacie(){
        return NodeData.builder()
                .key("Macie")
                .text("Macie")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-Macie_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addSecurityLake(){
        return NodeData.builder()
                .key("Security Lake")
                .text("Security Lake")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-Security-Lake_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addVerifiedPermissions(){
        return NodeData.builder()
                .key("Verified Permissions")
                .text("Verified Permissions")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_Amazon-Verified-Permissions_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addArtifact(){
        return NodeData.builder()
                .key("Artifact")
                .text("Artifact")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Artifact_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addAuditManager(){
        return NodeData.builder()
                .key("Audit Manager")
                .text("Audit Manager")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Audit-Manager_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addCertificateManager(){
        return NodeData.builder()
                .key("Certificate Manager")
                .text("Certificate Manager")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Certificate-Manager_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addCloudHSM(){
        return NodeData.builder()
                .key("CloudHSM")
                .text("CloudHSM")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-CloudHSM_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addDirectoryService(){
        return NodeData.builder()
                .key("Directory Service")
                .text("Directory Service")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Directory-Service_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addFirewallManager(){
        return NodeData.builder()
                .key("Firewall Manager")
                .text("Firewall Manager")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Firewall-Manager_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMIdentityCenter(){
        return NodeData.builder()
                .key("IAM Identity Center")
                .text("IAM Identity Center")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-IAM-Identity-Center_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIdentityandAccessManagementIAM(){
        return NodeData.builder()
                .key("Identity and Access Management (IAM)")
                .text("Identity and Access Management (IAM)")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Identity-and-Access-Management_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addKeyManagementService(){
        return NodeData.builder()
                .key("Key Management Service")
                .text("Key Management Service")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Key-Management-Service_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addNetworkFirewall(){
        return NodeData.builder()
                .key("Network Firewall")
                .text("Network Firewall")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Network-Firewall_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addPrivateCertificateAuthority(){
        return NodeData.builder()
                .key("Private Certificate Authority")
                .text("Private Certificate Authority")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Private-Certificate-Authority_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addResourceAccessManager(){
        return NodeData.builder()
                .key("Resource Access Manager")
                .text("Resource Access Manager")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Resource-Access-Manager_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addSecretsManager(){
        return NodeData.builder()
                .key("Secrets Manager")
                .text("Secrets Manager")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Secrets-Manager_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addSecurityHub(){
        return NodeData.builder()
                .key("Security Hub")
                .text("Security Hub")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Security-Hub_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addShield(){
        return NodeData.builder()
                .key("Shield")
                .text("Shield")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Shield_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addSigner(){
        return NodeData.builder()
                .key("Signer")
                .text("Signer")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-Signer_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addAWS_WAF(){
        return NodeData.builder()
                .key("AWS_WAF")
                .text("AWS_WAF")
                .source("/img/AWS_icon/Arch_Security-Identity-Compliance/Arch_AWS-WAF_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addElasticFileSystmeEFS(){
        return NodeData.builder()
                .key("Elastic File Systme (EFS)")
                .text("Elastic File Systme (EFS)")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-EFS_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3(){
        return NodeData.builder()
                .key("S3")
                .text("S3")
                .source("/img/AWS_icon/Arch_Storage/Res_Amazon-Simple-Storage-Service_S3-Standard_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addElasticBlockStore(){
        return NodeData.builder()
                .key("Elastic Block Store")
                .text("Elastic Block Store")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-Elastic-Block-Store_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFileCache(){
        return NodeData.builder()
                .key("File Cache")
                .text("File Cache")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-File-Cache_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFSxforLustre(){
        return NodeData.builder()
                .key("FSx for Lustre")
                .text("FSx for Lustre")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-FSx-for-Lustre_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFSxforNetAppONTAP(){
        return NodeData.builder()
                .key("FSx for NetApp ONTAP")
                .text("FSx for NetApp ONTAP")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-FSx-for-NetApp-ONTAP_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFSxforOpenZFS(){
        return NodeData.builder()
                .key("FSx for OpenZFS")
                .text("FSx for OpenZFS")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-FSx-for-OpenZFS_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFSxforWFS(){
        return NodeData.builder()
                .key("FSx for WFS")
                .text("FSx for WFS")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-FSx-for-WFS_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFSx(){
        return NodeData.builder()
                .key("FSx")
                .text("FSx")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-FSx_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3onOutposts(){
        return NodeData.builder()
                .key("S3 on Outposts")
                .text("S3 on Outposts")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-S3-on-Outposts_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSimpleStorageServiceGlacier(){
        return NodeData.builder()
                .key("Simple Storage Service Glacier")
                .text("Simple Storage Service Glacier")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-Simple-Storage-Service-Glacier_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSimpleStorageServiceS3(){
        return NodeData.builder()
                .key("Simple Storage Service (S3)")
                .text("Simple Storage Service (S3)")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-Simple-Storage-Service_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSimpleStorageServiceS3(List<NodeData> nodeDataList){
        return NodeData.builder()
                .key("Simple Storage Service (S3) "+diagramDTOService.getNodeNumber(nodeDataList, "Simple Storage Service (S3)"))
                .text("Simple Storage Service (S3)")
                .source("/img/AWS_icon/Arch_Storage/Arch_Amazon-Simple-Storage-Service_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackup(){
        return NodeData.builder()
                .key("Backup")
                .text("Backup")
                .source("/img/AWS_icon/Arch_Storage/Arch_AWS-Backup_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addElasticDisasterRecovery(){
        return NodeData.builder()
                .key("Elastic Disaster Recovery")
                .text("Elastic Disaster Recovery")
                .source("/img/AWS_icon/Arch_Storage/Arch_AWS-Elastic-Disaster-Recovery_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSnowballEdge(){
        return NodeData.builder()
                .key("Snowball Edge")
                .text("Snowball Edge")
                .source("/img/AWS_icon/Arch_Storage/Arch_AWS-Snowball-Edge_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSnowball(){
        return NodeData.builder()
                .key("Snowball")
                .text("Snowball")
                .source("/img/AWS_icon/Arch_Storage/Arch_AWS-Snowball_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSnowcone(){
        return NodeData.builder()
                .key("Snowcone")
                .text("Snowcone")
                .source("/img/AWS_icon/Arch_Storage/Arch_AWS-Snowcone_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSnowmobile(){
        return NodeData.builder()
                .key("Snowmobile")
                .text("Snowmobile")
                .source("/img/AWS_icon/Arch_Storage/Arch_AWS-Snowmobile_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGateway(){
        return NodeData.builder()
                .key("Storage Gateway")
                .text("Storage Gateway")
                .source("/img/AWS_icon/Arch_Storage/Arch_AWS-Storage-Gateway_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addAthenaDataSourceConnectors(){
        return NodeData.builder()
                .key("Athena Data Source Connectors")
                .text("Athena Data Source Connectors")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Athena_Data-Source-Connectors_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addCloudSearchSearchDocuments(){
        return NodeData.builder()
                .key("CloudSearch Search Documents")
                .text("CloudSearch Search Documents")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-CloudSearch_Search-Documents_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addDataZoneBusinessDataCatalog(){
        return NodeData.builder()
                .key("DataZone Business Data Catalog")
                .text("DataZone Business Data Catalog")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-DataZone_Business-Data-Catalog_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addDataZoneDataPortal(){
        return NodeData.builder()
                .key("DataZone Data Portal")
                .text("DataZone Data Portal")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-DataZone_Data-Portal_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addDataZoneDataProjects(){
        return NodeData.builder()
                .key("DataZone Data Projects")
                .text("DataZone Data Projects")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-DataZone_Data-Projects_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addEMRCluster(){
        return NodeData.builder()
                .key("EMR Cluster")
                .text("EMR Cluster")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-EMR_Cluster_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addEMREMREngine(){
        return NodeData.builder()
                .key("EMR EMR Engine")
                .text("EMR EMR Engine")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-EMR_EMR-Engine_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addEMRHDFSCluster(){
        return NodeData.builder()
                .key("EMR HDFS Cluster")
                .text("EMR HDFS Cluster")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-EMR_HDFS-Cluster_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addMSKMSKConnect(){
        return NodeData.builder()
                .key("MSK MSK Connect")
                .text("MSK MSK Connect")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-MSK_Amazon-MSK-Connect_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceClusterAdministratorNode(){
        return NodeData.builder()
                .key("OpenSearch Service Cluster Administrator Node")
                .text("OpenSearch Service Cluster Administrator Node")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_Cluster-Administrator-Node_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceDataNode(){
        return NodeData.builder()
                .key("OpenSearch Service Data Node")
                .text("OpenSearch Service Data Node")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_Data-Node_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceIndex(){
        return NodeData.builder()
                .key("OpenSearch Service Index")
                .text("OpenSearch Service Index")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_Index_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceObservability(){
        return NodeData.builder()
                .key("OpenSearch Service Observability")
                .text("OpenSearch Service Observability")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_Observability_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceOpenSearchDashboards(){
        return NodeData.builder()
                .key("OpenSearch Service OpenSearch Dashboards")
                .text("OpenSearch Service OpenSearch Dashboards")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_OpenSearch-Dashboards_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceOpenSearchIngestion(){
        return NodeData.builder()
                .key("OpenSearch Service OpenSearch Ingestion")
                .text("OpenSearch Service OpenSearch Ingestion")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_OpenSearch-Ingestion_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceTraces(){
        return NodeData.builder()
                .key("OpenSearch Service Traces")
                .text("OpenSearch Service Traces")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_Traces_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addOpenSearchServiceUltraWarmNode(){
        return NodeData.builder()
                .key("OpenSearch Service UltraWarm Node")
                .text("OpenSearch Service UltraWarm Node")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-OpenSearch-Service_UltraWarm-Node_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addQuicksightPaginatedReports(){
        return NodeData.builder()
                .key("Quicksight Paginated Reports")
                .text("Quicksight Paginated Reports")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Quicksight_Paginated-Reports_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftAutocopy(){
        return NodeData.builder()
                .key("Redshift Auto copy")
                .text("Redshift Auto copy")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_Auto-copy_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftDataSharingGovernance(){
        return NodeData.builder()
                .key("Redshift Data Sharing Governance")
                .text("Redshift Data Sharing Governance")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_Data-Sharing-Governance_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftDenseComputeNode(){
        return NodeData.builder()
                .key("Redshift Dense Compute Node")
                .text("Redshift Dense Compute Node")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_Dense-Compute-Node_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftDenseStorageNode(){
        return NodeData.builder()
                .key("Redshift Dense Storage Node")
                .text("Redshift Dense Storage Node")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_Dense-Storage-Node_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftML(){
        return NodeData.builder()
                .key("Redshift ML")
                .text("Redshift ML")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_ML_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftQueryEditorv(){
        return NodeData.builder()
                .key("Redshift Query Editor v2.0")
                .text("Redshift Query Editor v2.0")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_Query-Editor-v2.0_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftRA3(){
        return NodeData.builder()
                .key("Redshift RA3")
                .text("Redshift RA3")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_RA3_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addRedshiftStreamingIngestion(){
        return NodeData.builder()
                .key("Redshift Streaming Ingestion")
                .text("Redshift Streaming Ingestion")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_Amazon-Redshift_Streaming-Ingestion_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addDataExchangeforAPIs(){
        return NodeData.builder()
                .key("Data Exchange for APIs")
                .text("Data Exchange for APIs")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_AWS-Data-Exchange-for-APIs_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addGlueGlueforRay(){
        return NodeData.builder()
                .key("Glue Glue for Ray")
                .text("Glue Glue for Ray")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_AWS-Glue_AWS-Glue-for-Ray_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addGlueCrawler(){
        return NodeData.builder()
                .key("Glue Crawler")
                .text("Glue Crawler")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_AWS-Glue_Crawler_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addGlueDataCatalog(){
        return NodeData.builder()
                .key("Glue Data Catalog")
                .text("Glue Data Catalog")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_AWS-Glue_Data-Catalog_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addGlueDataQuality(){
        return NodeData.builder()
                .key("Glue Data Quality")
                .text("Glue Data Quality")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_AWS-Glue_Data-Quality_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addLakeFormationDataLake(){
        return NodeData.builder()
                .key("Lake Formation Data Lake")
                .text("Lake Formation Data Lake")
                .source("/img/AWS_icon/Resource_icon/Res_Analytics/Res_AWS-Lake-Formation_Data-Lake_48.svg")
                .type("Analytics")
                .build();
    }

    public NodeData addAPIGatewayEndpoint(){
        return NodeData.builder()
                .key("API Gateway Endpoint")
                .text("API Gateway Endpoint")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-API-Gateway_Endpoint_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeEvent(){
        return NodeData.builder()
                .key("EventBridge Event")
                .text("EventBridge Event")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge-Event_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeCustomEventBus(){
        return NodeData.builder()
                .key("EventBridge Custom Event Bus")
                .text("EventBridge Custom Event Bus")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Custom-Event-Bus_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeDefaultEventBus(){
        return NodeData.builder()
                .key("EventBridge Default Event Bus")
                .text("EventBridge Default Event Bus")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Default-Event-Bus_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgePipes(){
        return NodeData.builder()
                .key("EventBridge Pipes")
                .text("EventBridge Pipes")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Pipes_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeRule(){
        return NodeData.builder()
                .key("EventBridge Rule")
                .text("EventBridge Rule")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Rule_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeSaasPartnerEvent(){
        return NodeData.builder()
                .key("EventBridge Saas Partner Event")
                .text("EventBridge Saas Partner Event")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Saas-Partner-Event_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeScheduler(){
        return NodeData.builder()
                .key("EventBridge Scheduler")
                .text("EventBridge Scheduler")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Scheduler_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeSchemaRegistry(){
        return NodeData.builder()
                .key("EventBridge Schema Registry")
                .text("EventBridge Schema Registry")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Schema-Registry_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addEventBridgeSchema(){
        return NodeData.builder()
                .key("EventBridge Schema")
                .text("EventBridge Schema")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-EventBridge_Schema_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addMQBroker(){
        return NodeData.builder()
                .key("MQ Broker")
                .text("MQ Broker")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-MQ_Broker_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addSimpleNotificationServiceEmailNotification(){
        return NodeData.builder()
                .key("Simple Notification Service Email Notification")
                .text("Simple Notification Service Email Notification")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-Simple-Notification-Service_Email-Notification_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addSimpleNotificationServiceHTTPNotification(){
        return NodeData.builder()
                .key("Simple Notification Service HTTP Notification")
                .text("Simple Notification Service HTTP Notification")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-Simple-Notification-Service_HTTP-Notification_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addSimpleNotificationServiceTopic(){
        return NodeData.builder()
                .key("Simple Notification Service Topic")
                .text("Simple Notification Service Topic")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-Simple-Notification-Service_Topic_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addSimpleQueueServiceMessage(){
        return NodeData.builder()
                .key("Simple Queue Service Message")
                .text("Simple Queue Service Message")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-Simple-Queue-Service_Message_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addSimpleQueueServiceQueue(){
        return NodeData.builder()
                .key("Simple Queue Service Queue")
                .text("Simple Queue Service Queue")
                .source("/img/AWS_icon/Resource_icon/Res_Application-Integration/Res_Amazon-Simple-Queue-Service_Queue_48.svg")
                .type("App-Integration")
                .build();
    }

    public NodeData addManagedBlockchainBlockchain(){
        return NodeData.builder()
                .key("Managed Blockchain Blockchain")
                .text("Managed Blockchain Blockchain")
                .source("/img/AWS_icon/Resource_icon/Res_Blockchain/Res_Amazon-Managed-Blockchain_Blockchain_48.svg")
                .type("Blockchain")
                .build();
    }

    public NodeData addPinpointJourney(){
        return NodeData.builder()
                .key("Pinpoint Journey")
                .text("Pinpoint Journey")
                .source("/img/AWS_icon/Resource_icon/Res_Business-Applications/Res_Amazon-Pinpoint_Journey_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addSimpleEmailServiceEmail(){
        return NodeData.builder()
                .key("Simple Email Service Email")
                .text("Simple Email Service Email")
                .source("/img/AWS_icon/Resource_icon/Res_Business-Applications/Res_Amazon-Simple-Email-Service_Email_48.svg")
                .type("Business-Applications")
                .build();
    }

    public NodeData addA1(){
        return NodeData.builder()
                .key("A1")
                .text("A1")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/A1.svg")
                .type("Compute")
                .build();
    }

    public NodeData addC3(){
        return NodeData.builder()
                .key("C3")
                .text("C3")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/C3.svg")
                .type("Compute")
                .build();
    }

    public NodeData addC4(){
        return NodeData.builder()
                .key("C4")
                .text("C4")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/C4.svg")
                .type("Compute")
                .build();
    }

    public NodeData addC5(){
        return NodeData.builder()
                .key("C5")
                .text("C5")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/C5.svg")
                .type("Compute")
                .build();
    }

    public NodeData addC6i(){
        return NodeData.builder()
                .key("C6i")
                .text("C6i")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/C6i.svg")
                .type("Compute")
                .build();
    }

    public NodeData addC6in(){
        return NodeData.builder()
                .key("C6in")
                .text("C6in")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/C6in.svg")
                .type("Compute")
                .build();
    }

    public NodeData addC7g(){
        return NodeData.builder()
                .key("C7g")
                .text("C7g")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/C7g.svg")
                .type("Compute")
                .build();
    }

    public NodeData addC7gn(){
        return NodeData.builder()
                .key("C7gn")
                .text("C7gn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/C7gn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addCloudwatchinstance(){
        return NodeData.builder()
                .key("Cloudwatch instance")
                .text("Cloudwatch instance")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Cloudwatch instance.svg")
                .type("Compute")
                .build();
    }

    public NodeData addD2(){
        return NodeData.builder()
                .key("D2")
                .text("D2")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/D2.svg")
                .type("Compute")
                .build();
    }

    public NodeData addD3(){
        return NodeData.builder()
                .key("D3")
                .text("D3")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/D3.svg")
                .type("Compute")
                .build();
    }

    public NodeData addD3en(){
        return NodeData.builder()
                .key("D3en")
                .text("D3en")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/D3en.svg")
                .type("Compute")
                .build();
    }

    public NodeData addDBinstance(){
        return NodeData.builder()
                .key("DB instance")
                .text("DB instance")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/DB instance.svg")
                .type("Compute")
                .build();
    }

    public NodeData addF1(){
        return NodeData.builder()
                .key("F1")
                .text("F1")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/F1.svg")
                .type("Compute")
                .build();
    }

    public NodeData addG3(){
        return NodeData.builder()
                .key("G3")
                .text("G3")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/G3.svg")
                .type("Compute")
                .build();
    }

    public NodeData addG4ad(){
        return NodeData.builder()
                .key("G4ad")
                .text("G4ad")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/G4ad.svg")
                .type("Compute")
                .build();
    }

    public NodeData addG4dn(){
        return NodeData.builder()
                .key("G4dn")
                .text("G4dn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/G4dn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addG5(){
        return NodeData.builder()
                .key("G5")
                .text("G5")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/G5.svg")
                .type("Compute")
                .build();
    }

    public NodeData addG5g(){
        return NodeData.builder()
                .key("G5g")
                .text("G5g")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/G5g.svg")
                .type("Compute")
                .build();
    }

    public NodeData addH1(){
        return NodeData.builder()
                .key("H1")
                .text("H1")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/H1.svg")
                .type("Compute")
                .build();
    }

    public NodeData addHabanaGaudi(){
        return NodeData.builder()
                .key("Habana Gaudi")
                .text("Habana Gaudi")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Habana Gaudi.svg")
                .type("Compute")
                .build();
    }

    public NodeData addHMI(){
        return NodeData.builder()
                .key("HMI")
                .text("HMI")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/HMI.svg")
                .type("Compute")
                .build();
    }

    public NodeData addHpc6a(){
        return NodeData.builder()
                .key("Hpc6a")
                .text("Hpc6a")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Hpc6a.svg")
                .type("Compute")
                .build();
    }

    public NodeData addHpc6id(){
        return NodeData.builder()
                .key("Hpc6id")
                .text("Hpc6id")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Hpc6id.svg")
                .type("Compute")
                .build();
    }

    public NodeData addI2(){
        return NodeData.builder()
                .key("I2")
                .text("I2")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/I2.svg")
                .type("Compute")
                .build();
    }

    public NodeData addI3(){
        return NodeData.builder()
                .key("I3")
                .text("I3")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/I3.svg")
                .type("Compute")
                .build();
    }

    public NodeData addI3en(){
        return NodeData.builder()
                .key("I3en")
                .text("I3en")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/I3en.svg")
                .type("Compute")
                .build();
    }

    public NodeData addI4i(){
        return NodeData.builder()
                .key("I4i")
                .text("I4i")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/I4i.svg")
                .type("Compute")
                .build();
    }

    public NodeData addIm4gn(){
        return NodeData.builder()
                .key("Im4gn")
                .text("Im4gn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Im4gn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM1Mac(){
        return NodeData.builder()
                .key("M1Mac")
                .text("M1Mac")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M1Mac.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM4(){
        return NodeData.builder()
                .key("M4")
                .text("M4")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M4.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM5(){
        return NodeData.builder()
                .key("M5")
                .text("M5")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M5.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM5a(){
        return NodeData.builder()
                .key("M5a")
                .text("M5a")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M5a.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM5d(){
        return NodeData.builder()
                .key("M5d")
                .text("M5d")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M5d.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM5dn(){
        return NodeData.builder()
                .key("M5dn")
                .text("M5dn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M5dn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM5n(){
        return NodeData.builder()
                .key("M5n")
                .text("M5n")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M5n.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM5zn(){
        return NodeData.builder()
                .key("M5zn")
                .text("M5zn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M5zn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM6a(){
        return NodeData.builder()
                .key("M6a")
                .text("M6a")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M6a.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM6g(){
        return NodeData.builder()
                .key("M6g")
                .text("M6g")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M6g.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM6gd(){
        return NodeData.builder()
                .key("M6gd")
                .text("M6gd")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M6gd.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM6i(){
        return NodeData.builder()
                .key("M6i")
                .text("M6i")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M6i.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM6idn(){
        return NodeData.builder()
                .key("M6idn")
                .text("M6idn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M6idn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addM6in(){
        return NodeData.builder()
                .key("M6in")
                .text("M6in")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/M6in.svg")
                .type("Compute")
                .build();
    }

    public NodeData addMac(){
        return NodeData.builder()
                .key("Mac")
                .text("Mac")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Mac.svg")
                .type("Compute")
                .build();
    }

    public NodeData addP2(){
        return NodeData.builder()
                .key("P2")
                .text("P2")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/P2.svg")
                .type("Compute")
                .build();
    }

    public NodeData addP3(){
        return NodeData.builder()
                .key("P3")
                .text("P3")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/P3.svg")
                .type("Compute")
                .build();
    }

    public NodeData addP3dn(){
        return NodeData.builder()
                .key("P3dn")
                .text("P3dn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/P3dn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addP4(){
        return NodeData.builder()
                .key("P4")
                .text("P4")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/P4.svg")
                .type("Compute")
                .build();
    }

    public NodeData addP4d(){
        return NodeData.builder()
                .key("P4d")
                .text("P4d")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/P4d.svg")
                .type("Compute")
                .build();
    }

    public NodeData addP4de(){
        return NodeData.builder()
                .key("P4de")
                .text("P4de")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/P4de.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR4(){
        return NodeData.builder()
                .key("R4")
                .text("R4")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R4.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR5(){
        return NodeData.builder()
                .key("R5")
                .text("R5")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R5.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR5a(){
        return NodeData.builder()
                .key("R5a")
                .text("R5a")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R5a.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR5ad(){
        return NodeData.builder()
                .key("R5ad")
                .text("R5ad")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R5ad.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR5b(){
        return NodeData.builder()
                .key("R5b")
                .text("R5b")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R5b.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR5d(){
        return NodeData.builder()
                .key("R5d")
                .text("R5d")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R5d.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR5gd(){
        return NodeData.builder()
                .key("R5gd")
                .text("R5gd")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R5gd.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR5n(){
        return NodeData.builder()
                .key("R5n")
                .text("R5n")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R5n.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR6a(){
        return NodeData.builder()
                .key("R6a")
                .text("R6a")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R6a.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR6g(){
        return NodeData.builder()
                .key("R6g")
                .text("R6g")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R6g.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR6i(){
        return NodeData.builder()
                .key("R6i")
                .text("R6i")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R6i.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR6idn(){
        return NodeData.builder()
                .key("R6idn")
                .text("R6idn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R6idn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR6in(){
        return NodeData.builder()
                .key("R6in")
                .text("R6in")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R6in.svg")
                .type("Compute")
                .build();
    }

    public NodeData addR7iz(){
        return NodeData.builder()
                .key("R7iz")
                .text("R7iz")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/R7iz.svg")
                .type("Compute")
                .build();
    }

    public NodeData addRdn(){
        return NodeData.builder()
                .key("Rdn")
                .text("Rdn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Rdn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2AMI(){
        return NodeData.builder()
                .key("EC2 AMI")
                .text("EC2 AMI")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_AMI_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2AutoScalingRes(){
        return NodeData.builder()
                .key("EC2 Auto Scaling")
                .text("EC2 Auto Scaling")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_Auto-Scaling_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2MicroserviceExtractorforNET(){
        return NodeData.builder()
                .key("EC2 Microservice Extractor for .NET")
                .text("EC2 Microservice Extractor for .NET")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_AWS-Microservice-Extractor-for-.NET_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2DBInstance(){
        return NodeData.builder()
                .key("EC2 DB Instance")
                .text("EC2 DB Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_DB-Instance_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2ElasticIPAddress(){
        return NodeData.builder()
                .key("EC2 Elastic IP Address")
                .text("EC2 Elastic IP Address")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_Elastic-IP-Address_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2InstancewithCloudWatch(){
        return NodeData.builder()
                .key("EC2 Instance with CloudWatch")
                .text("EC2 Instance with CloudWatch")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_Instance-with-CloudWatch_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2Instances(){
        return NodeData.builder()
                .key("EC2 Instances")
                .text("EC2 Instances")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_Instances_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2Instance(){
        return NodeData.builder()
                .key("EC2 Instance")
                .text("EC2 Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_Instance_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2Rescue(){
        return NodeData.builder()
                .key("EC2 Rescue")
                .text("EC2 Rescue")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_Rescue_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addEC2SpotInstance(){
        return NodeData.builder()
                .key("EC2 Spot Instance")
                .text("EC2 Spot Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_Amazon-EC2_Spot-Instance_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addElasticBeanstalkApplication(){
        return NodeData.builder()
                .key("Elastic Beanstalk Application")
                .text("Elastic Beanstalk Application")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_AWS-Elastic-Beanstalk_Application_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addElasticBeanstalkDeployment(){
        return NodeData.builder()
                .key("Elastic Beanstalk Deployment")
                .text("Elastic Beanstalk Deployment")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_AWS-Elastic-Beanstalk_Deployment_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addLambdaLambdaFunction(){
        return NodeData.builder()
                .key("Lambda Lambda Function")
                .text("Lambda Lambda Function")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Res_AWS-Lambda_Lambda-Function_48.svg")
                .type("Compute")
                .build();
    }

    public NodeData addspotinstance(){
        return NodeData.builder()
                .key("spot instance")
                .text("spot instance")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/spot instance.svg")
                .type("Compute")
                .build();
    }

    public NodeData addT2(){
        return NodeData.builder()
                .key("T2")
                .text("T2")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/T2.svg")
                .type("Compute")
                .build();
    }

    public NodeData addT3(){
        return NodeData.builder()
                .key("T3")
                .text("T3")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/T3.svg")
                .type("Compute")
                .build();
    }

    public NodeData addT3a(){
        return NodeData.builder()
                .key("T3a")
                .text("T3a")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/T3a.svg")
                .type("Compute")
                .build();
    }

    public NodeData addT4g(){
        return NodeData.builder()
                .key("T4g")
                .text("T4g")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/T4g.svg")
                .type("Compute")
                .build();
    }

    public NodeData addTrainium(){
        return NodeData.builder()
                .key("Trainium")
                .text("Trainium")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Trainium.svg")
                .type("Compute")
                .build();
    }

    public NodeData addVT1(){
        return NodeData.builder()
                .key("VT1")
                .text("VT1")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/VT1.svg")
                .type("Compute")
                .build();
    }

    public NodeData addX1(){
        return NodeData.builder()
                .key("X1")
                .text("X1")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/X1.svg")
                .type("Compute")
                .build();
    }

    public NodeData addX1e(){
        return NodeData.builder()
                .key("X1e")
                .text("X1e")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/X1e.svg")
                .type("Compute")
                .build();
    }

    public NodeData addX2gd(){
        return NodeData.builder()
                .key("X2gd")
                .text("X2gd")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/X2gd.svg")
                .type("Compute")
                .build();
    }

    public NodeData addX2idn(){
        return NodeData.builder()
                .key("X2idn")
                .text("X2idn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/X2idn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addX2iedn(){
        return NodeData.builder()
                .key("X2iedn")
                .text("X2iedn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/X2iedn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addX2iezn(){
        return NodeData.builder()
                .key("X2iezn")
                .text("X2iezn")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/X2iezn.svg")
                .type("Compute")
                .build();
    }

    public NodeData addZ1d(){
        return NodeData.builder()
                .key("Z1d")
                .text("Z1d")
                .source("/img/AWS_icon/Resource_icon/Res_Compute/Z1d.svg")
                .type("Compute")
                .build();
    }

    public NodeData addElasticContainerRegistryImage(){
        return NodeData.builder()
                .key("Elastic Container Registry Image")
                .text("Elastic Container Registry Image")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Registry_Image_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerRegistryRegistry(){
        return NodeData.builder()
                .key("Elastic Container Registry Registry")
                .text("Elastic Container Registry Registry")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Registry_Registry_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerServiceContainer1(){
        return NodeData.builder()
                .key("Elastic Container Service Container 1")
                .text("Elastic Container Service Container 1")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Service_Container-1_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerServiceContainer2(){
        return NodeData.builder()
                .key("Elastic Container Service Container 2")
                .text("Elastic Container Service Container 2")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Service_Container-2_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerServiceContainer3(){
        return NodeData.builder()
                .key("Elastic Container Service Container 3")
                .text("Elastic Container Service Container 3")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Service_Container-3_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerServiceCopiIoTCLI(){
        return NodeData.builder()
                .key("Elastic Container Service CopiIoT CLI")
                .text("Elastic Container Service CopiIoT CLI")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Service_CopiIoT-CLI_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerServiceECSServiceConnect(){
        return NodeData.builder()
                .key("Elastic Container Service ECS Service Connect")
                .text("Elastic Container Service ECS Service Connect")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Service_ECS-Service-Connect_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerServiceService(){
        return NodeData.builder()
                .key("Elastic Container Service Service")
                .text("Elastic Container Service Service")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Service_Service_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticContainerServiceTask(){
        return NodeData.builder()
                .key("Elastic Container Service Task")
                .text("Elastic Container Service Task")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Container-Service_Task_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addElasticKubernetesServiceEKSonOutposts(){
        return NodeData.builder()
                .key("Elastic Kubernetes Service EKS on Outposts")
                .text("Elastic Kubernetes Service EKS on Outposts")
                .source("/img/AWS_icon/Resource_icon/Res_Containers/Res_Amazon-Elastic-Kubernetes-Service_EKS-on-Outposts_48.svg")
                .type("Containers")
                .build();
    }

    public NodeData addAuroraInstance(){
        return NodeData.builder()
                .key("Aurora Instance")
                .text("Aurora Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraMariaDBInstanceAlternate(){
        return NodeData.builder()
                .key("Aurora MariaDB Instance Alternate")
                .text("Aurora MariaDB Instance Alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-MariaDB-Instance-Alternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraMariaDBInstance(){
        return NodeData.builder()
                .key("Aurora MariaDB Instance")
                .text("Aurora MariaDB Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-MariaDB-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraMySQLInstanceAlternate(){
        return NodeData.builder()
                .key("Aurora MySQL Instance Alternate")
                .text("Aurora MySQL Instance Alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-MySQL-Instance-Alternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraMySQLInstance(){
        return NodeData.builder()
                .key("Aurora MySQL Instance")
                .text("Aurora MySQL Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-MySQL-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraOracleInstanceAlternate(){
        return NodeData.builder()
                .key("Aurora Oracle Instance Alternate")
                .text("Aurora Oracle Instance Alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-Oracle-Instance-Alternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraOracleInstance(){
        return NodeData.builder()
                .key("Aurora Oracle Instance")
                .text("Aurora Oracle Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-Oracle-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraPIOPSInstance(){
        return NodeData.builder()
                .key("Aurora PIOPS Instance")
                .text("Aurora PIOPS Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-PIOPS-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraPostgreSQLInstanceAlternate(){
        return NodeData.builder()
                .key("Aurora PostgreSQL Instance Alternate")
                .text("Aurora PostgreSQL Instance Alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-PostgreSQL-Instance-Alternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraPostgreSQLInstance(){
        return NodeData.builder()
                .key("Aurora PostgreSQL Instance")
                .text("Aurora PostgreSQL Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-PostgreSQL-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraSQLServerInstanceAlternate(){
        return NodeData.builder()
                .key("Aurora SQL Server Instance Alternate")
                .text("Aurora SQL Server Instance Alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-SQL-Server-Instance-Alternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraSQLServerInstance(){
        return NodeData.builder()
                .key("Aurora SQL Server Instance")
                .text("Aurora SQL Server Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora-SQL-Server-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraAuroraInstancealternate(){
        return NodeData.builder()
                .key("Aurora Aurora Instance alternate")
                .text("Aurora Aurora Instance alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora_Amazon-Aurora-Instance-alternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraRDSInstanceAternate(){
        return NodeData.builder()
                .key("Aurora RDS Instance Aternate")
                .text("Aurora RDS Instance Aternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora_Amazon-RDS-Instance-Aternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraRDSInstance(){
        return NodeData.builder()
                .key("Aurora RDS Instance")
                .text("Aurora RDS Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora_Amazon-RDS-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addAuroraTrustedLanguageExtensionsforPostgreSQL(){
        return NodeData.builder()
                .key("Aurora Trusted Language Extensions for PostgreSQL")
                .text("Aurora Trusted Language Extensions for PostgreSQL")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-Aurora_Trusted-Language-Extensions-for-PostgreSQL_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDocumentDBElasticClusters(){
        return NodeData.builder()
                .key("DocumentDB Elastic Clusters")
                .text("DocumentDB Elastic Clusters")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DocumentDB_Elastic-Clusters_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBDynamoDBAccelerator(){
        return NodeData.builder()
                .key("DynamoDB DynamoDB Accelerator")
                .text("DynamoDB DynamoDB Accelerator")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Amazon-DynamoDB-Accelerator_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBAttributes(){
        return NodeData.builder()
                .key("DynamoDB Attributes")
                .text("DynamoDB Attributes")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Attributes_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBAttribute(){
        return NodeData.builder()
                .key("DynamoDB Attribute")
                .text("DynamoDB Attribute")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Attribute_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBGlobalsecondaryindex(){
        return NodeData.builder()
                .key("DynamoDB Global secondary index")
                .text("DynamoDB Global secondary index")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Global-secondary-index_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBItems(){
        return NodeData.builder()
                .key("DynamoDB Items")
                .text("DynamoDB Items")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Items_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBItem(){
        return NodeData.builder()
                .key("DynamoDB Item")
                .text("DynamoDB Item")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Item_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBStandardAccessTableClass(){
        return NodeData.builder()
                .key("DynamoDB Standard Access Table Class")
                .text("DynamoDB Standard Access Table Class")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Standard-Access-Table-Class_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBStandardInfrequentAccessTableClass(){
        return NodeData.builder()
                .key("DynamoDB Standard Infrequent Access Table Class")
                .text("DynamoDB Standard Infrequent Access Table Class")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Standard-Infrequent-Access-Table-Class_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBStream(){
        return NodeData.builder()
                .key("DynamoDB Stream")
                .text("DynamoDB Stream")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Stream_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDynamoDBTable(){
        return NodeData.builder()
                .key("DynamoDB Table")
                .text("DynamoDB Table")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-DynamoDB_Table_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addElastiCacheCacheNode(){
        return NodeData.builder()
                .key("ElastiCache Cache Node")
                .text("ElastiCache Cache Node")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-ElastiCache_Cache-Node_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addElastiCacheElastiCacheforMemcached(){
        return NodeData.builder()
                .key("ElastiCache ElastiCache for Memcached")
                .text("ElastiCache ElastiCache for Memcached")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-ElastiCache_ElastiCache-for-Memcached_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addElastiCacheElastiCacheforRedis(){
        return NodeData.builder()
                .key("ElastiCache ElastiCache for Redis")
                .text("ElastiCache ElastiCache for Redis")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-ElastiCache_ElastiCache-for-Redis_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSProxyInstanceAlternate(){
        return NodeData.builder()
                .key("RDS Proxy Instance Alternate")
                .text("RDS Proxy Instance Alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-RDS-Proxy-Instance-Alternate_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSProxyInstance(){
        return NodeData.builder()
                .key("RDS Proxy Instance")
                .text("RDS Proxy Instance")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-RDS-Proxy-Instance_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSBlueGreenDeployments(){
        return NodeData.builder()
                .key("RDS Blue Green Deployments")
                .text("RDS Blue Green Deployments")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-RDS_Blue-Green-Deployments_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSMultiAZDBCluster(){
        return NodeData.builder()
                .key("RDS Multi AZ DB Cluster")
                .text("RDS Multi AZ DB Cluster")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-RDS_Multi-AZ-DB-Cluster_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSMultiAZ(){
        return NodeData.builder()
                .key("RDS Multi AZ")
                .text("RDS Multi AZ")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-RDS_Multi-AZ_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSOptimizedWrites(){
        return NodeData.builder()
                .key("RDS Optimized Writes")
                .text("RDS Optimized Writes")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-RDS_Optimized-Writes_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRDSTrustedLanguageExtensionsforPostgreSQL(){
        return NodeData.builder()
                .key("RDS Trusted Language Extensions for PostgreSQL")
                .text("RDS Trusted Language Extensions for PostgreSQL")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_Amazon-RDS_Trusted-Language-Extensions-for-PostgreSQL_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addDatabaseMigrationServiceDatabasemigrationworkfloworjob(){
        return NodeData.builder()
                .key("Database Migration Service Database migration workflow or job")
                .text("Database Migration Service Database migration workflow or job")
                .source("/img/AWS_icon/Resource_icon/Res_Database/Res_AWS-Database-Migration-Service_Database-migration-workflow-or-job_48.svg")
                .type("Database")
                .build();
    }

    public NodeData addRes_Cloud9(){
        return NodeData.builder()
                .key("Res_Cloud9")
                .text("Cloud9")
                .source("/img/AWS_icon/Resource_icon/Res_Developer-Tools/Res_AWS-Cloud9_Cloud9_48.svg")
                .type("Developer-Tools")
                .build();
    }

    public NodeData addWorkSpacesCore(){
        return NodeData.builder()
                .key("WorkSpaces Core")
                .text("WorkSpaces Core")
                .source("/img/AWS_icon/Resource_icon/Res_End-User-Computing/Res_Amazon-WorkSpaces-Family_Amazon-WorkSpaces-Core_48.svg")
                .type("End-User-Computing")
                .build();
    }

    public NodeData addWorkSpacesWeb(){
        return NodeData.builder()
                .key("WorkSpaces Web")
                .text("WorkSpaces Web")
                .source("/img/AWS_icon/Resource_icon/Res_End-User-Computing/Res_Amazon-WorkSpaces-Family_Amazon-WorkSpaces-Web_48.svg")
                .type("End-User-Computing")
                .build();
    }

    public NodeData addWorkSpaces(){
        return NodeData.builder()
                .key("WorkSpaces")
                .text("WorkSpaces")
                .source("/img/AWS_icon/Resource_icon/Res_End-User-Computing/Res_Amazon-WorkSpaces-Family_Amazon-WorkSpaces_48.svg")
                .type("End-User-Computing")
                .build();
    }

    public NodeData addLocationServiceGeofence(){
        return NodeData.builder()
                .key("Location Service Geofence")
                .text("Location Service Geofence")
                .source("/img/AWS_icon/Resource_icon/Res_Front-End-Web-Mobile/Res_Amazon-Location-Service_Geofence_48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addLocationServiceMap(){
        return NodeData.builder()
                .key("Location Service Map")
                .text("Location Service Map")
                .source("/img/AWS_icon/Resource_icon/Res_Front-End-Web-Mobile/Res_Amazon-Location-Service_Map _48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addLocationServicePlace(){
        return NodeData.builder()
                .key("Location Service Place")
                .text("Location Service Place")
                .source("/img/AWS_icon/Resource_icon/Res_Front-End-Web-Mobile/Res_Amazon-Location-Service_Place_48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addLocationServiceRoutes(){
        return NodeData.builder()
                .key("Location Service Routes")
                .text("Location Service Routes")
                .source("/img/AWS_icon/Resource_icon/Res_Front-End-Web-Mobile/Res_Amazon-Location-Service_Routes_48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addLocationServiceTrack(){
        return NodeData.builder()
                .key("Location Service Track")
                .text("Location Service Track")
                .source("/img/AWS_icon/Resource_icon/Res_Front-End-Web-Mobile/Res_Amazon-Location-Service_Track _48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addAmplifyStudio(){
        return NodeData.builder()
                .key("Amplify Studio")
                .text("Amplify Studio")
                .source("/img/AWS_icon/Resource_icon/Res_Front-End-Web-Mobile/Res_AWS-Amplify_AWS-Amplify-Studio_48.svg")
                .type("Front-End-Web-Mobile")
                .build();
    }

    public NodeData addAlert(){
        return NodeData.builder()
                .key("Alert")
                .text("Alert")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Alert_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addAuthenticatedUser(){
        return NodeData.builder()
                .key("Authenticated User")
                .text("Authenticated User")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Authenticated-User_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addManagementConsoleRes(){
        return NodeData.builder()
                .key("Management Console")
                .text("Management Console")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_AWS-Management-Console_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addCamera(){
        return NodeData.builder()
                .key("Camera")
                .text("Camera")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Camera_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addChat(){
        return NodeData.builder()
                .key("Chat")
                .text("Chat")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Chat_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addClient(){
        return NodeData.builder()
                .key("Client")
                .text("Client")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Client_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addColdStorage(){
        return NodeData.builder()
                .key("Cold Storage")
                .text("Cold Storage")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Cold-Storage_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addCredentials(){
        return NodeData.builder()
                .key("Credentials")
                .text("Credentials")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Credentials_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addDataStream(){
        return NodeData.builder()
                .key("Data Stream")
                .text("Data Stream")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Data-Stream_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addDataTable(){
        return NodeData.builder()
                .key("Data Table")
                .text("Data Table")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Data-Table_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addDatabaseRes(){
        return NodeData.builder()
                .key("Database")
                .text("Database")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Database_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addDisk(){
        return NodeData.builder()
                .key("Disk")
                .text("Disk")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Disk_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addDocuments(){
        return NodeData.builder()
                .key("Documents")
                .text("Documents")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Documents_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addDocument(){
        return NodeData.builder()
                .key("Document")
                .text("Document")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Document_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addEmail(){
        return NodeData.builder()
                .key("Email")
                .text("Email")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Email_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addRes_Firewall(){
        return NodeData.builder()
                .key("Res_Firewall")
                .text("Firewall")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Firewall_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addFolders(){
        return NodeData.builder()
                .key("Folders")
                .text("Folders")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Folders_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addFolder(){
        return NodeData.builder()
                .key("Folder")
                .text("Folder")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Folder_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addForums(){
        return NodeData.builder()
                .key("Forums")
                .text("Forums")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Forums_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addGear(){
        return NodeData.builder()
                .key("Gear")
                .text("Gear")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Gear_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addGenericApplication(){
        return NodeData.builder()
                .key("Generic Application")
                .text("Generic Application")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Generic-Application_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addGitRepository(){
        return NodeData.builder()
                .key("Git Repository")
                .text("Git Repository")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Git-Repository_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addGlobe(){
        return NodeData.builder()
                .key("Globe")
                .text("Globe")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Globe_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addInternetalt1(){
        return NodeData.builder()
                .key("Internet alt1")
                .text("Internet alt1")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Internet-alt1_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addInternetalt2(){
        return NodeData.builder()
                .key("Internet alt2")
                .text("Internet alt2")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Internet-alt2_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addInternet(){
        return NodeData.builder()
                .key("Internet")
                .text("Internet")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Internet_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addJSONScript(){
        return NodeData.builder()
                .key("JSON Script")
                .text("JSON Script")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_JSON-Script_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addLogs(){
        return NodeData.builder()
                .key("Logs")
                .text("Logs")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Logs_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addMagnifyingGlass(){
        return NodeData.builder()
                .key("Magnifying Glass")
                .text("Magnifying Glass")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Magnifying-Glass_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addMetrics(){
        return NodeData.builder()
                .key("Metrics")
                .text("Metrics")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Metrics_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addMobileclient(){
        return NodeData.builder()
                .key("Mobile client")
                .text("Mobile client")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Mobile-client_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addMultimedia(){
        return NodeData.builder()
                .key("Multimedia")
                .text("Multimedia")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Multimedia_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addOfficebuilding(){
        return NodeData.builder()
                .key("Office building")
                .text("Office building")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Office-building_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addProgrammingLanguage(){
        return NodeData.builder()
                .key("Programming Language")
                .text("Programming Language")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Programming-Language_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addQuestion(){
        return NodeData.builder()
                .key("Question")
                .text("Question")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Question_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addRecover(){
        return NodeData.builder()
                .key("Recover")
                .text("Recover")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Recover_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addSAMLtoken(){
        return NodeData.builder()
                .key("SAML token")
                .text("SAML token")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_SAML-token_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addSDK(){
        return NodeData.builder()
                .key("SDK")
                .text("SDK")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_SDK_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addServers(){
        return NodeData.builder()
                .key("Servers")
                .text("Servers")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Servers_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addServerRes(){
        return NodeData.builder()
                .key("Server")
                .text("Server")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Server_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addShieldRes(){
        return NodeData.builder()
                .key("Shield")
                .text("Shield")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Shield_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addSourceCode(){
        return NodeData.builder()
                .key("Source Code")
                .text("Source Code")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Source-Code_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addSSLpadlock(){
        return NodeData.builder()
                .key("SSL padlock")
                .text("SSL padlock")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_SSL-padlock_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addTapestorage(){
        return NodeData.builder()
                .key("Tape storage")
                .text("Tape storage")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Tape-storage_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addToolkit(){
        return NodeData.builder()
                .key("Toolkit")
                .text("Toolkit")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Toolkit_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addUsers(){
        return NodeData.builder()
                .key("Users")
                .text("Users")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_Users_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addUser(){
        return NodeData.builder()
                .key("User")
                .text("User")
                .source("/img/AWS_icon/Resource_icon/Res_General-Icons/Res_48_Light/Res_User_48_Light.svg")
                .type("General-Icons")
                .build();
    }

    public NodeData addIoTAnalyticsChannel(){
        return NodeData.builder()
                .key("IoT Analytics Channel")
                .text("IoT Analytics Channel")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Analytics_Channel_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAnalyticsDataStore(){
        return NodeData.builder()
                .key("IoT Analytics Data Store")
                .text("IoT Analytics Data Store")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Analytics_Data-Store_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAnalyticsDataset(){
        return NodeData.builder()
                .key("IoT Analytics Dataset")
                .text("IoT Analytics Dataset")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Analytics_Dataset_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAnalyticsNotebook(){
        return NodeData.builder()
                .key("IoT Analytics Notebook")
                .text("IoT Analytics Notebook")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Analytics_Notebook_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAnalyticsPipeline(){
        return NodeData.builder()
                .key("IoT Analytics Pipeline")
                .text("IoT Analytics Pipeline")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Analytics_Pipeline_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTCoreDeviceAdvisor(){
        return NodeData.builder()
                .key("IoT Core Device Advisor")
                .text("IoT Core Device Advisor")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Core_Device-Advisor_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTCoreDeviceLocation(){
        return NodeData.builder()
                .key("IoT Core Device Location")
                .text("IoT Core Device Location")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Core_Device-Location_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTDeviceDefenderIoTDeviceJobs(){
        return NodeData.builder()
                .key("IoT Device Defender IoT Device Jobs")
                .text("IoT Device Defender IoT Device Jobs")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Device-Defender_IoT-Device-Jobs_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTDeviceManagementFleetHub(){
        return NodeData.builder()
                .key("IoT Device Management Fleet Hub")
                .text("IoT Device Management Fleet Hub")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Device-Management_Fleet-Hub_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTDeviceTester(){
        return NodeData.builder()
                .key("IoT Device Tester")
                .text("IoT Device Tester")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Device-Tester_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassArtifact(){
        return NodeData.builder()
                .key("IoT Greengrass Artifact")
                .text("IoT Greengrass Artifact")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Artifact_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassComponentMachineLearning(){
        return NodeData.builder()
                .key("IoT Greengrass Component Machine Learning")
                .text("IoT Greengrass Component Machine Learning")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Component-Machine-Learning_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassComponentNucleus(){
        return NodeData.builder()
                .key("IoT Greengrass Component Nucleus")
                .text("IoT Greengrass Component Nucleus")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Component-Nucleus_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassComponentPrivate(){
        return NodeData.builder()
                .key("IoT Greengrass Component Private")
                .text("IoT Greengrass Component Private")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Component-Private_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassComponentPublic(){
        return NodeData.builder()
                .key("IoT Greengrass Component Public")
                .text("IoT Greengrass Component Public")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Component-Public_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassComponent(){
        return NodeData.builder()
                .key("IoT Greengrass Component")
                .text("IoT Greengrass Component")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Component_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassConnector(){
        return NodeData.builder()
                .key("IoT Greengrass Connector")
                .text("IoT Greengrass Connector")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Connector_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassInterprocessCommunication(){
        return NodeData.builder()
                .key("IoT Greengrass Interprocess Communication")
                .text("IoT Greengrass Interprocess Communication")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Interprocess-Communication_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassProtocol(){
        return NodeData.builder()
                .key("IoT Greengrass Protocol")
                .text("IoT Greengrass Protocol")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Protocol_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassRecipe(){
        return NodeData.builder()
                .key("IoT Greengrass Recipe")
                .text("IoT Greengrass Recipe")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Recipe_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTGreengrassStreamManager(){
        return NodeData.builder()
                .key("IoT Greengrass Stream Manager")
                .text("IoT Greengrass Stream Manager")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Greengrass_Stream-Manager_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTHardwareBoard(){
        return NodeData.builder()
                .key("IoT Hardware Board")
                .text("IoT Hardware Board")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Hardware-Board_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTRule(){
        return NodeData.builder()
                .key("IoT Rule")
                .text("IoT Rule")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-Rule_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSiteWiseAssetHierarchy(){
        return NodeData.builder()
                .key("IoT SiteWise Asset Hierarchy")
                .text("IoT SiteWise Asset Hierarchy")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-SiteWise_Asset-Hierarchy_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSiteWiseAssetModel(){
        return NodeData.builder()
                .key("IoT SiteWise Asset Model")
                .text("IoT SiteWise Asset Model")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-SiteWise_Asset-Model_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSiteWiseAssetProperties(){
        return NodeData.builder()
                .key("IoT SiteWise Asset Properties")
                .text("IoT SiteWise Asset Properties")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-SiteWise_Asset-Properties_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSiteWiseAsset(){
        return NodeData.builder()
                .key("IoT SiteWise Asset")
                .text("IoT SiteWise Asset")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-SiteWise_Asset_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSiteWiseDataStreams(){
        return NodeData.builder()
                .key("IoT SiteWise Data Streams")
                .text("IoT SiteWise Data Streams")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT-SiteWise_Data-Streams_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAction(){
        return NodeData.builder()
                .key("IoT Action")
                .text("IoT Action")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Action_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTActuator(){
        return NodeData.builder()
                .key("IoT Actuator")
                .text("IoT Actuator")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Actuator_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAlexaEnabledDevice(){
        return NodeData.builder()
                .key("IoT Alexa Enabled Device")
                .text("IoT Alexa Enabled Device")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Alexa_Enabled-Device_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAlexaSkill(){
        return NodeData.builder()
                .key("IoT Alexa Skill")
                .text("IoT Alexa Skill")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Alexa_Skill_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTAlexaVoiceService(){
        return NodeData.builder()
                .key("IoT Alexa Voice Service")
                .text("IoT Alexa Voice Service")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Alexa_Voice-Service_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTCertificate(){
        return NodeData.builder()
                .key("IoT Certificate")
                .text("IoT Certificate")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Certificate_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTDesiredState(){
        return NodeData.builder()
                .key("IoT Desired State")
                .text("IoT Desired State")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Desired-State_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTDeviceGateway(){
        return NodeData.builder()
                .key("IoT Device Gateway")
                .text("IoT Device Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Device-Gateway_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTEcho(){
        return NodeData.builder()
                .key("IoT Echo")
                .text("IoT Echo")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Echo_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTFireTVStick(){
        return NodeData.builder()
                .key("IoT Fire TV Stick")
                .text("IoT Fire TV Stick")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Fire-TV_Stick_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTFireTV(){
        return NodeData.builder()
                .key("IoT Fire TV")
                .text("IoT Fire TV")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Fire_TV_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTHTTP2Protocol(){
        return NodeData.builder()
                .key("IoT HTTP2 Protocol")
                .text("IoT HTTP2 Protocol")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_HTTP2-Protocol_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTHTTPProtocol(){
        return NodeData.builder()
                .key("IoT HTTP Protocol")
                .text("IoT HTTP Protocol")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_HTTP_Protocol_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTLambdaFunction(){
        return NodeData.builder()
                .key("IoT Lambda Function")
                .text("IoT Lambda Function")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Lambda_Function_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTLoRaWANProtocol(){
        return NodeData.builder()
                .key("IoT LoRaWAN Protocol")
                .text("IoT LoRaWAN Protocol")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_LoRaWAN-Protocol_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTMQTTProtocol(){
        return NodeData.builder()
                .key("IoT MQTT Protocol")
                .text("IoT MQTT Protocol")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_MQTT_Protocol_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTOverAirUpdate(){
        return NodeData.builder()
                .key("IoT Over Air Update")
                .text("IoT Over Air Update")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Over-Air-Update_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTPolicy(){
        return NodeData.builder()
                .key("IoT Policy")
                .text("IoT Policy")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Policy_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTReportedState(){
        return NodeData.builder()
                .key("IoT Reported State")
                .text("IoT Reported State")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Reported-State_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSailboat(){
        return NodeData.builder()
                .key("IoT Sailboat")
                .text("IoT Sailboat")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Sailboat_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSensor(){
        return NodeData.builder()
                .key("IoT Sensor")
                .text("IoT Sensor")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Sensor_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTServo(){
        return NodeData.builder()
                .key("IoT Servo")
                .text("IoT Servo")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Servo_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTShadow(){
        return NodeData.builder()
                .key("IoT Shadow")
                .text("IoT Shadow")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Shadow_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTSimulator(){
        return NodeData.builder()
                .key("IoT Simulator")
                .text("IoT Simulator")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Simulator_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingBank(){
        return NodeData.builder()
                .key("IoT Thing Bank")
                .text("IoT Thing Bank")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Bank_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingBicycle(){
        return NodeData.builder()
                .key("IoT Thing Bicycle")
                .text("IoT Thing Bicycle")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Bicycle_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingCamera(){
        return NodeData.builder()
                .key("IoT Thing Camera")
                .text("IoT Thing Camera")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Camera_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingCart(){
        return NodeData.builder()
                .key("IoT Thing Cart")
                .text("IoT Thing Cart")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Cart_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingCar(){
        return NodeData.builder()
                .key("IoT Thing Car")
                .text("IoT Thing Car")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Car_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingCoffeePot(){
        return NodeData.builder()
                .key("IoT Thing Coffee Pot")
                .text("IoT Thing Coffee Pot")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Coffee-Pot_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingDoorLock(){
        return NodeData.builder()
                .key("IoT Thing Door Lock")
                .text("IoT Thing Door Lock")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Door-Lock_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingFactory(){
        return NodeData.builder()
                .key("IoT Thing Factory")
                .text("IoT Thing Factory")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Factory_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingFreeRTOSDevice(){
        return NodeData.builder()
                .key("IoT Thing FreeRTOS Device")
                .text("IoT Thing FreeRTOS Device")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_FreeRTOS-Device_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingGeneric(){
        return NodeData.builder()
                .key("IoT Thing Generic")
                .text("IoT Thing Generic")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Generic_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingHouse(){
        return NodeData.builder()
                .key("IoT Thing House")
                .text("IoT Thing House")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_House_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingHumiditySensor(){
        return NodeData.builder()
                .key("IoT Thing Humidity Sensor")
                .text("IoT Thing Humidity Sensor")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Humidity-Sensor_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingIndustrialPC(){
        return NodeData.builder()
                .key("IoT Thing Industrial PC")
                .text("IoT Thing Industrial PC")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Industrial-PC_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingLightbulb(){
        return NodeData.builder()
                .key("IoT Thing Lightbulb")
                .text("IoT Thing Lightbulb")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Lightbulb_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingMedicalEmergency(){
        return NodeData.builder()
                .key("IoT Thing Medical Emergency")
                .text("IoT Thing Medical Emergency")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Medical-Emergency_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingPLC(){
        return NodeData.builder()
                .key("IoT Thing PLC")
                .text("IoT Thing PLC")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_PLC_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingPoliceEmergency(){
        return NodeData.builder()
                .key("IoT Thing Police Emergency")
                .text("IoT Thing Police Emergency")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Police-Emergency_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingRelay(){
        return NodeData.builder()
                .key("IoT Thing Relay")
                .text("IoT Thing Relay")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Relay_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingStacklight(){
        return NodeData.builder()
                .key("IoT Thing Stacklight")
                .text("IoT Thing Stacklight")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Stacklight_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingTemperatureHumiditySensor(){
        return NodeData.builder()
                .key("IoT Thing Temperature Humidity Sensor")
                .text("IoT Thing Temperature Humidity Sensor")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Temperature-Humidity-Sensor_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingTemperatureSensor(){
        return NodeData.builder()
                .key("IoT Thing Temperature Sensor")
                .text("IoT Thing Temperature Sensor")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Temperature-Sensor_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingTemperatureVibrationSensor(){
        return NodeData.builder()
                .key("IoT Thing Temperature Vibration Sensor")
                .text("IoT Thing Temperature Vibration Sensor")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Temperature-Vibration-Sensor_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingThermostat(){
        return NodeData.builder()
                .key("IoT Thing Thermostat")
                .text("IoT Thing Thermostat")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Thermostat_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingTravel(){
        return NodeData.builder()
                .key("IoT Thing Travel")
                .text("IoT Thing Travel")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Travel_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingUtility(){
        return NodeData.builder()
                .key("IoT Thing Utility")
                .text("IoT Thing Utility")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Utility_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingVibrationSensor(){
        return NodeData.builder()
                .key("IoT Thing Vibration Sensor")
                .text("IoT Thing Vibration Sensor")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Vibration-Sensor_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTThingWindfarm(){
        return NodeData.builder()
                .key("IoT Thing Windfarm")
                .text("IoT Thing Windfarm")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Thing_Windfarm_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addIoTTopic(){
        return NodeData.builder()
                .key("IoT Topic")
                .text("IoT Topic")
                .source("/img/AWS_icon/Resource_icon/Res_IoT/Res_AWS-IoT_Topic_48.svg")
                .type("Internet-of-Things")
                .build();
    }

    public NodeData addDevOpsGuruInsights(){
        return NodeData.builder()
                .key("DevOps Guru Insights")
                .text("DevOps Guru Insights")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-DevOps-Guru_Insights_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addRekognitionImage(){
        return NodeData.builder()
                .key("Rekognition Image")
                .text("Rekognition Image")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-Rekognition_Image_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addRekognitionVideo(){
        return NodeData.builder()
                .key("Rekognition Video")
                .text("Rekognition Video")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-Rekognition_Video_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerCanvas(){
        return NodeData.builder()
                .key("SageMaker Canvas")
                .text("SageMaker Canvas")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-SageMaker_Canvas_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerGeospatialML(){
        return NodeData.builder()
                .key("SageMaker Geospatial ML")
                .text("SageMaker Geospatial ML")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-SageMaker_Geospatial-ML_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerModel(){
        return NodeData.builder()
                .key("SageMaker Model")
                .text("SageMaker Model")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-SageMaker_Model_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerNotebook(){
        return NodeData.builder()
                .key("SageMaker Notebook")
                .text("SageMaker Notebook")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-SageMaker_Notebook_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerShadowTesting(){
        return NodeData.builder()
                .key("SageMaker Shadow Testing")
                .text("SageMaker Shadow Testing")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-SageMaker_Shadow-Testing_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addSageMakerTrain(){
        return NodeData.builder()
                .key("SageMaker Train")
                .text("SageMaker Train")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-SageMaker_Train_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addTextractAnalyzeLending(){
        return NodeData.builder()
                .key("Textract Analyze Lending")
                .text("Textract Analyze Lending")
                .source("/img/AWS_icon/Resource_icon/Res_Machine-Learning/Res_Amazon-Textract_Analyze-Lending_48.svg")
                .type("Machine-Learning")
                .build();
    }

    public NodeData addCloudWatchAlarm(){
        return NodeData.builder()
                .key("CloudWatch Alarm")
                .text("CloudWatch Alarm")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Alarm_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchCrossaccountObservability(){
        return NodeData.builder()
                .key("CloudWatch Cross account Observability")
                .text("CloudWatch Cross account Observability")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Cross-account-Observability_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchDataProtection(){
        return NodeData.builder()
                .key("CloudWatch Data Protection")
                .text("CloudWatch Data Protection")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Data-Protection_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchEventEventBased(){
        return NodeData.builder()
                .key("CloudWatch Event Event Based")
                .text("CloudWatch Event Event Based")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Event-Event-Based_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchEventTimeBased(){
        return NodeData.builder()
                .key("CloudWatch Event Time Based")
                .text("CloudWatch Event Time Based")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Event-Time-Based_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchEvidently(){
        return NodeData.builder()
                .key("CloudWatch Evidently")
                .text("CloudWatch Evidently")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Evidently_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchLogs(){
        return NodeData.builder()
                .key("CloudWatch Logs")
                .text("CloudWatch Logs")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Logs_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchMetricsInsights(){
        return NodeData.builder()
                .key("CloudWatch Metrics Insights")
                .text("CloudWatch Metrics Insights")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Metrics-Insights_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchRule(){
        return NodeData.builder()
                .key("CloudWatch Rule")
                .text("CloudWatch Rule")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Rule_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchRUM(){
        return NodeData.builder()
                .key("CloudWatch RUM")
                .text("CloudWatch RUM")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_RUM_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudWatchSynthetics(){
        return NodeData.builder()
                .key("CloudWatch Synthetics")
                .text("CloudWatch Synthetics")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_Amazon-CloudWatch_Synthetics_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudFormationChangeSet(){
        return NodeData.builder()
                .key("CloudFormation Change Set")
                .text("CloudFormation Change Set")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-CloudFormation_Change-Set_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudFormationStack(){
        return NodeData.builder()
                .key("CloudFormation Stack")
                .text("CloudFormation Stack")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-CloudFormation_Stack_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudFormationTemplate(){
        return NodeData.builder()
                .key("CloudFormation Template")
                .text("CloudFormation Template")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-CloudFormation_Template_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudTrailCloudTrailLake(){
        return NodeData.builder()
                .key("CloudTrail CloudTrail Lake")
                .text("CloudTrail CloudTrail Lake")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-CloudTrail_CloudTrail-Lake_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addLicenseManagerApplicationDiscovery(){
        return NodeData.builder()
                .key("License Manager Application Discovery")
                .text("License Manager Application Discovery")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-License-Manager_Application-Discovery_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addLicenseManagerLicenseBlending(){
        return NodeData.builder()
                .key("License Manager License Blending")
                .text("License Manager License Blending")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-License-Manager_License-Blending_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksApps(){
        return NodeData.builder()
                .key("OpsWorks Apps")
                .text("OpsWorks Apps")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Apps_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksDeployments(){
        return NodeData.builder()
                .key("OpsWorks Deployments")
                .text("OpsWorks Deployments")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Deployments_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksInstances(){
        return NodeData.builder()
                .key("OpsWorks Instances")
                .text("OpsWorks Instances")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Instances_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksLayers(){
        return NodeData.builder()
                .key("OpsWorks Layers")
                .text("OpsWorks Layers")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Layers_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksMonitoring(){
        return NodeData.builder()
                .key("OpsWorks Monitoring")
                .text("OpsWorks Monitoring")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Monitoring_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksPermissions(){
        return NodeData.builder()
                .key("OpsWorks Permissions")
                .text("OpsWorks Permissions")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Permissions_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksResources(){
        return NodeData.builder()
                .key("OpsWorks Resources")
                .text("OpsWorks Resources")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Resources_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOpsWorksStack2(){
        return NodeData.builder()
                .key("OpsWorks Stack2")
                .text("OpsWorks Stack2")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-OpsWorks_Stack2_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOrganizationsAccount(){
        return NodeData.builder()
                .key("Organizations Account")
                .text("Organizations Account")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Organizations_Account_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOrganizationsManagementAccount(){
        return NodeData.builder()
                .key("Organizations Management Account")
                .text("Organizations Management Account")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Organizations_Management-Account_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addOrganizationsOrganizationalUnit(){
        return NodeData.builder()
                .key("Organizations Organizational Unit")
                .text("Organizations Organizational Unit")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Organizations_Organizational-Unit_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerApplicationManager(){
        return NodeData.builder()
                .key("Systems Manager Application Manager")
                .text("Systems Manager Application Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Application-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerAutomation(){
        return NodeData.builder()
                .key("Systems Manager Automation")
                .text("Systems Manager Automation")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Automation_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerChangeCalendar(){
        return NodeData.builder()
                .key("Systems Manager Change Calendar")
                .text("Systems Manager Change Calendar")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Change-Calendar_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerChangeManager(){
        return NodeData.builder()
                .key("Systems Manager Change Manager")
                .text("Systems Manager Change Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Change-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerCompliance(){
        return NodeData.builder()
                .key("Systems Manager Compliance")
                .text("Systems Manager Compliance")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Compliance_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerDistributor(){
        return NodeData.builder()
                .key("Systems Manager Distributor")
                .text("Systems Manager Distributor")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Distributor_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerDocuments(){
        return NodeData.builder()
                .key("Systems Manager Documents")
                .text("Systems Manager Documents")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Documents_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerIncidentManager(){
        return NodeData.builder()
                .key("Systems Manager Incident Manager")
                .text("Systems Manager Incident Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Incident-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerInventory(){
        return NodeData.builder()
                .key("Systems Manager Inventory")
                .text("Systems Manager Inventory")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Inventory_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerMaintenanceWindows(){
        return NodeData.builder()
                .key("Systems Manager Maintenance Windows")
                .text("Systems Manager Maintenance Windows")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Maintenance-Windows_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerOpsCenter(){
        return NodeData.builder()
                .key("Systems Manager OpsCenter")
                .text("Systems Manager OpsCenter")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_OpsCenter_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerParameterStore(){
        return NodeData.builder()
                .key("Systems Manager Parameter Store")
                .text("Systems Manager Parameter Store")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Parameter-Store_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerPatchManager(){
        return NodeData.builder()
                .key("Systems Manager Patch Manager")
                .text("Systems Manager Patch Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Patch-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerRunCommand(){
        return NodeData.builder()
                .key("Systems Manager Run Command")
                .text("Systems Manager Run Command")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Run-Command_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerSessionManager(){
        return NodeData.builder()
                .key("Systems Manager Session Manager")
                .text("Systems Manager Session Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_Session-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addSystemsManagerStateManager(){
        return NodeData.builder()
                .key("Systems Manager State Manager")
                .text("Systems Manager State Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Systems-Manager_State-Manager_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addTrustedAdvisorChecklistCost(){
        return NodeData.builder()
                .key("Trusted Advisor Checklist Cost")
                .text("Trusted Advisor Checklist Cost")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Trusted-Advisor_Checklist-Cost_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addTrustedAdvisorChecklistFaultTolerant(){
        return NodeData.builder()
                .key("Trusted Advisor Checklist Fault Tolerant")
                .text("Trusted Advisor Checklist Fault Tolerant")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Trusted-Advisor_Checklist-Fault-Tolerant_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addTrustedAdvisorChecklistPerformance(){
        return NodeData.builder()
                .key("Trusted Advisor Checklist Performance")
                .text("Trusted Advisor Checklist Performance")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Trusted-Advisor_Checklist-Performance_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addTrustedAdvisorChecklistSecurity(){
        return NodeData.builder()
                .key("Trusted Advisor Checklist Security")
                .text("Trusted Advisor Checklist Security")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Trusted-Advisor_Checklist-Security_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addTrustedAdvisorChecklist(){
        return NodeData.builder()
                .key("Trusted Advisor Checklist")
                .text("Trusted Advisor Checklist")
                .source("/img/AWS_icon/Resource_icon/Res_Management-Governance/Res_AWS-Trusted-Advisor_Checklist_48.svg")
                .type("Management-Governance")
                .build();
    }

    public NodeData addCloudDigitalInterface(){
        return NodeData.builder()
                .key("Cloud Digital Interface")
                .text("Cloud Digital Interface")
                .source("/img/AWS_icon/Resource_icon/Res_Media-Services/Res_AWS-Cloud-Digital-Interface_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addElementalMediaConnectMediaConnectGateway(){
        return NodeData.builder()
                .key("Elemental MediaConnect MediaConnect Gateway")
                .text("Elemental MediaConnect MediaConnect Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Media-Services/Res_AWS-Elemental-MediaConnect_MediaConnect-Gateway_48.svg")
                .type("Media-Services")
                .build();
    }

    public NodeData addApplicationDiscoveryServiceAgentlessCollector(){
        return NodeData.builder()
                .key("Application Discovery Service Agentless Collector")
                .text("Application Discovery Service Agentless Collector")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Application-Discovery-Service_AWS-Agentless-Collector_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addApplicationDiscoveryServiceDiscoveryAgent(){
        return NodeData.builder()
                .key("Application Discovery Service Discovery Agent")
                .text("Application Discovery Service Discovery Agent")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Application-Discovery-Service_AWS-Discovery-Agent_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addApplicationDiscoveryServiceMigrationEvaluatorCollector(){
        return NodeData.builder()
                .key("Application Discovery Service Migration Evaluator Collector")
                .text("Application Discovery Service Migration Evaluator Collector")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Application-Discovery-Service_Migration-Evaluator-Collector_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addDatasyncAgent(){
        return NodeData.builder()
                .key("Datasync Agent")
                .text("Datasync Agent")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Datasync_Agent_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addDataSyncDiscovery(){
        return NodeData.builder()
                .key("DataSync Discovery")
                .text("DataSync Discovery")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-DataSync_Discovery_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMainframeModernizationAnalyzer(){
        return NodeData.builder()
                .key("Mainframe Modernization Analyzer")
                .text("Mainframe Modernization Analyzer")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Mainframe-Modernization_Analyzer_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMainframeModernizationCompiler(){
        return NodeData.builder()
                .key("Mainframe Modernization Compiler")
                .text("Mainframe Modernization Compiler")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Mainframe-Modernization_Compiler_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMainframeModernizationConverter(){
        return NodeData.builder()
                .key("Mainframe Modernization Converter")
                .text("Mainframe Modernization Converter")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Mainframe-Modernization_Converter_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMainframeModernizationDeveloper(){
        return NodeData.builder()
                .key("Mainframe Modernization Developer")
                .text("Mainframe Modernization Developer")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Mainframe-Modernization_Developer_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMainframeModernizationRuntime(){
        return NodeData.builder()
                .key("Mainframe Modernization Runtime")
                .text("Mainframe Modernization Runtime")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Mainframe-Modernization_Runtime_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMigrationHubRefactorSpacesApplications(){
        return NodeData.builder()
                .key("Migration Hub Refactor Spaces Applications")
                .text("Migration Hub Refactor Spaces Applications")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Migration-Hub_Refactor-Spaces-Applications_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMigrationHubRefactorSpacesEnvironments(){
        return NodeData.builder()
                .key("Migration Hub Refactor Spaces Environments")
                .text("Migration Hub Refactor Spaces Environments")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Migration-Hub_Refactor-Spaces-Environments_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addMigrationHubRefactorSpacesServices(){
        return NodeData.builder()
                .key("Migration Hub Refactor Spaces Services")
                .text("Migration Hub Refactor Spaces Services")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Migration-Hub_Refactor-Spaces-Services_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addTransferFamilyAS2(){
        return NodeData.builder()
                .key("Transfer Family AS2")
                .text("Transfer Family AS2")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Transfer-Family_AWS-AS2_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addTransferFamilyFTPS(){
        return NodeData.builder()
                .key("Transfer Family FTPS")
                .text("Transfer Family FTPS")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Transfer-Family_AWS-FTPS_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addTransferFamilyFTP(){
        return NodeData.builder()
                .key("Transfer Family FTP")
                .text("Transfer Family FTP")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Transfer-Family_AWS-FTP_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addTransferFamilySFTP(){
        return NodeData.builder()
                .key("Transfer Family SFTP")
                .text("Transfer Family SFTP")
                .source("/img/AWS_icon/Resource_icon/Res_Migration-Transfer/Res_AWS-Transfer-Family_AWS-SFTP_48.svg")
                .type("Migration-Transfer")
                .build();
    }

    public NodeData addCloudFrontDownloadDistribution(){
        return NodeData.builder()
                .key("CloudFront Download Distribution")
                .text("CloudFront Download Distribution")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-CloudFront_Download-Distribution_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudFrontEdgeLocation(){
        return NodeData.builder()
                .key("CloudFront Edge Location")
                .text("CloudFront Edge Location")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-CloudFront_Edge-Location_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudFrontFunctions(){
        return NodeData.builder()
                .key("CloudFront Functions")
                .text("CloudFront Functions")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-CloudFront_Functions_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudFrontStreamingDistribution(){
        return NodeData.builder()
                .key("CloudFront Streaming Distribution")
                .text("CloudFront Streaming Distribution")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-CloudFront_Streaming-Distribution_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53HostedZone(){
        return NodeData.builder()
                .key("Route 53 Hosted Zone")
                .text("Route 53 Hosted Zone")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53-Hosted-Zone_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53ReadinessChecks(){
        return NodeData.builder()
                .key("Route 53 Readiness Checks")
                .text("Route 53 Readiness Checks")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53_Readiness-Checks_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53ResolverDNSFirewall(){
        return NodeData.builder()
                .key("Route 53 Resolver DNS Firewall")
                .text("Route 53 Resolver DNS Firewall")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53_Resolver-DNS-Firewall_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53ResolverQueryLogging(){
        return NodeData.builder()
                .key("Route 53 Resolver Query Logging")
                .text("Route 53 Resolver Query Logging")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53_Resolver-Query-Logging_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53Resolver(){
        return NodeData.builder()
                .key("Route 53 Resolver")
                .text("Route 53 Resolver")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53_Resolver_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53ApplicationRecoveryController(){
        return NodeData.builder()
                .key("Route 53 Application Recovery Controller")
                .text("Route 53 Application Recovery Controller")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53_Route-53-Application-Recovery-Controller_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53RouteTable(){
        return NodeData.builder()
                .key("Route 53 Route Table")
                .text("Route 53 Route Table")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53_Route-Table_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRoute53RoutingControls(){
        return NodeData.builder()
                .key("Route 53 Routing Controls")
                .text("Route 53 Routing Controls")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-Route-53_Routing-Controls_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCarrierGateway(){
        return NodeData.builder()
                .key("Carrier Gateway")
                .text("Carrier Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Carrier-Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCustomerGateway(){
        return NodeData.builder()
                .key("Customer Gateway")
                .text("Customer Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Customer-Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addElasticNetworkAdapter(){
        return NodeData.builder()
                .key("Elastic Network Adapter")
                .text("Elastic Network Adapter")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Elastic-Network-Adapter_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addElasticNetworkInterface(){
        return NodeData.builder()
                .key("Elastic Network Interface")
                .text("Elastic Network Interface")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Elastic-Network-Interface_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addEndpoints(){
        return NodeData.builder()
                .key("Endpoints")
                .text("Endpoints")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Endpoints_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addFlowLogs(){
        return NodeData.builder()
                .key("Flow Logs")
                .text("Flow Logs")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Flow-Logs_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addInternetGateway(){
        return NodeData.builder()
                .key("Internet Gateway")
                .text("Internet Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Internet-Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addNATGateway(){
        return NodeData.builder()
                .key("NAT Gateway")
                .text("NAT Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_NAT-Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addNetworkAccessAnalyzer(){
        return NodeData.builder()
                .key("Network Access Analyzer")
                .text("Network Access Analyzer")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Network-Access-Analyzer_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addNetworkAccessControlListNACL(){
        return NodeData.builder()
                .key("Network Access Control List (NACL)")
                .text("Network Access Control List (NACL)")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Network-Access-Control-List_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addPeeringConnection(){
        return NodeData.builder()
                .key("Peering Connection")
                .text("Peering Connection")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Peering-Connection_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addReachabilityAnalyzer(){
        return NodeData.builder()
                .key("Reachability Analyzer")
                .text("Reachability Analyzer")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Reachability-Analyzer_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addRouterRes(){
        return NodeData.builder()
                .key("Router")
                .text("Router")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Router_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addTrafficMirroring(){
        return NodeData.builder()
                .key("Traffic Mirroring")
                .text("Traffic Mirroring")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Traffic-Mirroring_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addVirtualprivatecloudVPC(){
        return NodeData.builder()
                .key("Virtual private cloud VPC")
                .text("Virtual private cloud VPC")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_Virtual-private-cloud-VPC_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addVPNConnection(){
        return NodeData.builder()
                .key("VPN Connection")
                .text("VPN Connection")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_VPN-Connection_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addVPNGateway(){
        return NodeData.builder()
                .key("VPN Gateway")
                .text("VPN Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Amazon-VPC_VPN-Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addAppMeshMesh(){
        return NodeData.builder()
                .key("App Mesh Mesh")
                .text("App Mesh Mesh")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-App-Mesh_Mesh_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addAppMeshVirtualGateway(){
        return NodeData.builder()
                .key("App Mesh Virtual Gateway")
                .text("App Mesh Virtual Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-App-Mesh_Virtual-Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addAppMeshVirtualNode(){
        return NodeData.builder()
                .key("App Mesh Virtual Node")
                .text("App Mesh Virtual Node")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-App-Mesh_Virtual-Node_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addAppMeshVirtualRouter(){
        return NodeData.builder()
                .key("App Mesh Virtual Router")
                .text("App Mesh Virtual Router")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-App-Mesh_Virtual-Router_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addAppMeshVirtualService(){
        return NodeData.builder()
                .key("App Mesh Virtual Service")
                .text("App Mesh Virtual Service")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-App-Mesh_Virtual-Service_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudMapNamespace(){
        return NodeData.builder()
                .key("Cloud Map Namespace")
                .text("Cloud Map Namespace")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Cloud-Map_Namespace_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudMapResource(){
        return NodeData.builder()
                .key("Cloud Map Resource")
                .text("Cloud Map Resource")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Cloud-Map_Resource_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudMapService(){
        return NodeData.builder()
                .key("Cloud Map Service")
                .text("Cloud Map Service")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Cloud-Map_Service_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudWANCoreNetworkEdge(){
        return NodeData.builder()
                .key("Cloud WAN Core Network Edge")
                .text("Cloud WAN Core Network Edge")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Cloud-WAN_Core-Network-Edge_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudWANSegmentNetwork(){
        return NodeData.builder()
                .key("Cloud WAN Segment Network")
                .text("Cloud WAN Segment Network")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Cloud-WAN_Segment-Network_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addCloudWANTransitGatewayRouteTableAttachment(){
        return NodeData.builder()
                .key("Cloud WAN Transit Gateway Route Table Attachment")
                .text("Cloud WAN Transit Gateway Route Table Attachment")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Cloud-WAN_Transit-Gateway-Route-Table-Attachment_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addDirectConnectGateway(){
        return NodeData.builder()
                .key("Direct Connect Gateway")
                .text("Direct Connect Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Direct-Connect_Gateway_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addTransitGatewayAttachment(){
        return NodeData.builder()
                .key("Transit Gateway Attachment")
                .text("Transit Gateway Attachment")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_AWS-Transit-Gateway_Attachment_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addApplicationLoadBalancerALB(){
        return NodeData.builder()
                .key("Application Load Balancer (ALB)")
                .text("Application Load Balancer (ALB)")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Elastic-Load-Balancing_Application-Load-Balancer_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addClassicLoadBalancerCLB(){
        return NodeData.builder()
                .key("Classic Load Balancer (CLB)")
                .text("Classic Load Balancer (CLB)")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Elastic-Load-Balancing_Classic-Load-Balancer_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addGatewayLoadBalancerGLB(){
        return NodeData.builder()
                .key("Gateway Load Balancer (GLB)")
                .text("Gateway Load Balancer (GLB)")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Elastic-Load-Balancing_Gateway-Load-Balancer_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addNetworkLoadBalancerNLB(){
        return NodeData.builder()
                .key("Network Load Balancer (NLB)")
                .text("Network Load Balancer (NLB)")
                .source("/img/AWS_icon/Resource_icon/Res_Networking-Content-Delivery/Res_Elastic-Load-Balancing_Network-Load-Balancer_48.svg")
                .type("Networking-Content-Delivery")
                .build();
    }

    public NodeData addBraketChandelier(){
        return NodeData.builder()
                .key("Braket Chandelier")
                .text("Braket Chandelier")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Chandelier_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketChip(){
        return NodeData.builder()
                .key("Braket Chip")
                .text("Braket Chip")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Chip_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketEmbeddedSimulator(){
        return NodeData.builder()
                .key("Braket Embedded Simulator")
                .text("Braket Embedded Simulator")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Embedded-Simulator_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketManagedSimulator(){
        return NodeData.builder()
                .key("Braket Managed Simulator")
                .text("Braket Managed Simulator")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Managed-Simulator_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketNoiseSimulator(){
        return NodeData.builder()
                .key("Braket Noise Simulator")
                .text("Braket Noise Simulator")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Noise-Simulator_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketQPU(){
        return NodeData.builder()
                .key("Braket QPU")
                .text("Braket QPU")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_QPU_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketSimulator1(){
        return NodeData.builder()
                .key("Braket Simulator 1")
                .text("Braket Simulator 1")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Simulator-1_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketSimulator2(){
        return NodeData.builder()
                .key("Braket Simulator 2")
                .text("Braket Simulator 2")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Simulator-2_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketSimulator3(){
        return NodeData.builder()
                .key("Braket Simulator 3")
                .text("Braket Simulator 3")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Simulator-3_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketSimulator4(){
        return NodeData.builder()
                .key("Braket Simulator 4")
                .text("Braket Simulator 4")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Simulator-4_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketSimulator(){
        return NodeData.builder()
                .key("Braket Simulator")
                .text("Braket Simulator")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Simulator_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketStateVector(){
        return NodeData.builder()
                .key("Braket State Vector")
                .text("Braket State Vector")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_State-Vector_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addBraketTensorNetwork(){
        return NodeData.builder()
                .key("Braket Tensor Network")
                .text("Braket Tensor Network")
                .source("/img/AWS_icon/Resource_icon/Res_Quantum-Technologies/Res_Amazon-Braket_Tensor-Network_48.svg")
                .type("Quantum-Technologies")
                .build();
    }

    public NodeData addRoboMakerCloudExtensionsROS(){
        return NodeData.builder()
                .key("RoboMaker Cloud Extensions ROS")
                .text("RoboMaker Cloud Extensions ROS")
                .source("/img/AWS_icon/Resource_icon/Res_Robotics/Res_AWS-RoboMaker_Cloud-Extensions-ROS_48.svg")
                .type("Robotics")
                .build();
    }

    public NodeData addRoboMakerDevelopmentEnvironment(){
        return NodeData.builder()
                .key("RoboMaker Development Environment")
                .text("RoboMaker Development Environment")
                .source("/img/AWS_icon/Resource_icon/Res_Robotics/Res_AWS-RoboMaker_Development-Environment_48.svg")
                .type("Robotics")
                .build();
    }

    public NodeData addRoboMakerFleetManagement(){
        return NodeData.builder()
                .key("RoboMaker Fleet Management")
                .text("RoboMaker Fleet Management")
                .source("/img/AWS_icon/Resource_icon/Res_Robotics/Res_AWS-RoboMaker_Fleet-Management_48.svg")
                .type("Robotics")
                .build();
    }

    public NodeData addRoboMakerSimulation(){
        return NodeData.builder()
                .key("RoboMaker Simulation")
                .text("RoboMaker Simulation")
                .source("/img/AWS_icon/Resource_icon/Res_Robotics/Res_AWS-RoboMaker_Simulation_48.svg")
                .type("Robotics")
                .build();
    }

    public NodeData addInspectorAgent(){
        return NodeData.builder()
                .key("Inspector Agent")
                .text("Inspector Agent")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_Amazon-Inspector_Agent_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addCertificateManagerCertificateAuthority(){
        return NodeData.builder()
                .key("Certificate Manager Certificate Authority")
                .text("Certificate Manager Certificate Authority")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Certificate-Manager_Certificate-Authority_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addDirectoryServiceADConnector(){
        return NodeData.builder()
                .key("Directory Service AD Connector")
                .text("Directory Service AD Connector")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Directory-Service_AD-Connector_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addDirectoryServiceManagedMicrosoftAD(){
        return NodeData.builder()
                .key("Directory Service Managed Microsoft AD")
                .text("Directory Service Managed Microsoft AD")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Directory-Service_AWS-Managed-Microsoft-AD_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addDirectoryServiceSimpleAD(){
        return NodeData.builder()
                .key("Directory Service Simple AD")
                .text("Directory Service Simple AD")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Directory-Service_Simple-AD_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMAddon(){
        return NodeData.builder()
                .key("IAM Add on")
                .text("IAM Add on")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_Add-on_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMSTSAlternate(){
        return NodeData.builder()
                .key("IAM STS Alternate")
                .text("IAM STS Alternate")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_AWS-STS-Alternate_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMSTS(){
        return NodeData.builder()
                .key("IAM STS")
                .text("IAM STS")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_AWS-STS_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMDataEncryptionKey(){
        return NodeData.builder()
                .key("IAM Data Encryption Key")
                .text("IAM Data Encryption Key")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_Data-Encryption-Key_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMEncryptedData(){
        return NodeData.builder()
                .key("IAM Encrypted Data")
                .text("IAM Encrypted Data")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_Encrypted-Data_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMAccessAnalyzer(){
        return NodeData.builder()
                .key("IAM Access Analyzer")
                .text("IAM Access Analyzer")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_IAM-Access-Analyzer_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMRolesAnywhere(){
        return NodeData.builder()
                .key("IAM Roles Anywhere")
                .text("IAM Roles Anywhere")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_IAM-Roles-Anywhere_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMLongTermSecurityCredential(){
        return NodeData.builder()
                .key("IAM Long Term Security Credential")
                .text("IAM Long Term Security Credential")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_Long-Term-Security-Credential_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMMFAToken(){
        return NodeData.builder()
                .key("IAM MFA Token")
                .text("IAM MFA Token")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_MFA-Token_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMPermissions(){
        return NodeData.builder()
                .key("IAM Permissions")
                .text("IAM Permissions")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_Permissions_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMRole(){
        return NodeData.builder()
                .key("IAM Role")
                .text("IAM Role")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_Role_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addIAMTemporarySecurityCredential(){
        return NodeData.builder()
                .key("IAM Temporary Security Credential")
                .text("IAM Temporary Security Credential")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Identity-Access-Management_Temporary-Security-Credential_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addKeyManagementServiceExternalKeyStore(){
        return NodeData.builder()
                .key("Key Management Service External Key Store")
                .text("Key Management Service External Key Store")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Key-Management-Service_External-Key-Store_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addNetworkFirewallEndpoints(){
        return NodeData.builder()
                .key("Network Firewall Endpoints")
                .text("Network Firewall Endpoints")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Network-Firewall_Endpoints_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addSecurityHubFinding(){
        return NodeData.builder()
                .key("Security Hub Finding")
                .text("Security Hub Finding")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Security-Hub_Finding_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addShieldShieldAdvanced(){
        return NodeData.builder()
                .key("Shield Shield Advanced")
                .text("Shield Shield Advanced")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-Shield_AWS-Shield-Advanced_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addWAFBadBot(){
        return NodeData.builder()
                .key("WAF Bad Bot")
                .text("WAF Bad Bot")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-WAF_Bad-Bot_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addWAFBotControl(){
        return NodeData.builder()
                .key("WAF Bot Control")
                .text("WAF Bot Control")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-WAF_Bot-Control_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addWAFBot(){
        return NodeData.builder()
                .key("WAF Bot")
                .text("WAF Bot")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-WAF_Bot_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addWAFFilteringRule(){
        return NodeData.builder()
                .key("WAF Filtering Rule")
                .text("WAF Filtering Rule")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-WAF_Filtering-Rule_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addWAFLabels(){
        return NodeData.builder()
                .key("WAF Labels")
                .text("WAF Labels")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-WAF_Labels_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addWAFManagedRule(){
        return NodeData.builder()
                .key("WAF Managed Rule")
                .text("WAF Managed Rule")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-WAF_Managed-Rule_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addWAFRule(){
        return NodeData.builder()
                .key("WAF Rule")
                .text("WAF Rule")
                .source("/img/AWS_icon/Resource_icon/Res_Security-Identity-Compliance/Res_AWS-WAF_Rule_48.svg")
                .type("Security-Identity-Compliance")
                .build();
    }

    public NodeData addElasticBlockStoreDataLifecycleManager(){
        return NodeData.builder()
                .key("Elastic Block Store Data Lifecycle Manager")
                .text("Elastic Block Store Data Lifecycle Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-Block-Store_Amazon-Data-Lifecycle-Manager_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addElasticBlockStoreMultipleVolumes(){
        return NodeData.builder()
                .key("Elastic Block Store Multiple Volumes")
                .text("Elastic Block Store Multiple Volumes")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-Block-Store_Multiple-Volumes_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addElasticBlockStoreSnapshot(){
        return NodeData.builder()
                .key("Elastic Block Store Snapshot")
                .text("Elastic Block Store Snapshot")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-Block-Store_Snapshot_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addElasticBlockStoreVolumegp3(){
        return NodeData.builder()
                .key("Elastic Block Store Volume gp3")
                .text("Elastic Block Store Volume gp3")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-Block-Store_Volume-gp3_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addElasticBlockStoreVolume(){
        return NodeData.builder()
                .key("Elastic Block Store Volume")
                .text("Elastic Block Store Volume")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-Block-Store_Volume_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addEFSIntelligentTiering(){
        return NodeData.builder()
                .key("EFS Intelligent Tiering")
                .text(" EFS Intelligent Tiering")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-File-System_EFS-Intelligent-Tiering_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addEFSOneZoneInfrequentAccess(){
        return NodeData.builder()
                .key(" EFS One Zone Infrequent Access")
                .text(" EFS One Zone Infrequent Access")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-File-System_EFS-One-Zone-Infrequent-Access_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addEFSOneZone(){
        return NodeData.builder()
                .key(" EFS One Zone")
                .text(" EFS One Zone")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-File-System_EFS-One-Zone_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addEFSStandardInfrequentAccess(){
        return NodeData.builder()
                .key(" EFS Standard Infrequent Access")
                .text(" EFS Standard Infrequent Access")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-File-System_EFS-Standard-Infrequent-Access_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addEFSStandard(){
        return NodeData.builder()
                .key(" EFS Standard")
                .text(" EFS Standard")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-File-System_EFS-Standard_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addEFSElasticThroughput(){
        return NodeData.builder()
                .key("EFS Elastic Throughput")
                .text("EFS Elastic Throughput")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-File-System_Elastic-Throughput_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addEFSFileSystem(){
        return NodeData.builder()
                .key("EFS File System")
                .text("EFS File System")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Elastic-File-System_File-System_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFileCacheHybridNFSlinkeddatasets(){
        return NodeData.builder()
                .key("File Cache Hybrid NFS linked datasets")
                .text("File Cache Hybrid NFS linked datasets")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-File-Cache_Hybrid-NFS-linked-datasets_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFileCacheOnpremisesNFSlinkeddatasets(){
        return NodeData.builder()
                .key("File Cache On premises NFS linked datasets")
                .text("File Cache On premises NFS linked datasets")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-File-Cache_On-premises-NFS-linked-datasets_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addFileCacheS3linkeddatasets(){
        return NodeData.builder()
                .key("File Cache S3 linked datasets")
                .text("File Cache S3 linked datasets")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-File-Cache_S3-linked-datasets_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3Glacierive(){
        return NodeData.builder()
                .key("S3 Glacier ive")
                .text("S3 Glacier ive")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service-Glacier_Archive_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3GlacierVault(){
        return NodeData.builder()
                .key("S3 Glacier Vault")
                .text("S3 Glacier Vault")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service-Glacier_Vault_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3BucketWithObjects(){
        return NodeData.builder()
                .key("S3 Bucket With Objects")
                .text("S3 Bucket With Objects")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_Bucket-With-Objects_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3Bucket(){
        return NodeData.builder()
                .key("S3 Bucket")
                .text("S3 Bucket")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_Bucket_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3GeneralAccessPoints(){
        return NodeData.builder()
                .key("S3 General Access Points")
                .text("S3 General Access Points")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_General-Access-Points_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3Object(){
        return NodeData.builder()
                .key("S3 Object")
                .text("S3 Object")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_Object_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3BatchOperations(){
        return NodeData.builder()
                .key("S3 Batch Operations")
                .text("S3 Batch Operations")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Batch-Operations_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3GlacierDeepive(){
        return NodeData.builder()
                .key("S3 Glacier Deep ive")
                .text("S3 Glacier Deep ive")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Glacier-Deep-Archive_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3GlacierFlexibleRetrieval(){
        return NodeData.builder()
                .key("S3 Glacier Flexible Retrieval")
                .text("S3 Glacier Flexible Retrieval")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Glacier-Flexible-Retrieval_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3GlacierInstantRetrieval(){
        return NodeData.builder()
                .key("S3 Glacier Instant Retrieval")
                .text("S3 Glacier Instant Retrieval")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Glacier-Instant-Retrieval_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3IntelligentTiering(){
        return NodeData.builder()
                .key("S3 Intelligent Tiering")
                .text("S3 Intelligent Tiering")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Intelligent-Tiering_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3MultiRegionAccessPoints(){
        return NodeData.builder()
                .key("S3 Multi Region Access Points")
                .text("S3 Multi Region Access Points")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Multi-Region-Access-Points_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3ObjectLambdaAccessPoints(){
        return NodeData.builder()
                .key("S3 Object Lambda Access Points")
                .text("S3 Object Lambda Access Points")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Object-Lambda-Access-Points_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3ObjectLambda(){
        return NodeData.builder()
                .key("S3 Object Lambda")
                .text("S3 Object Lambda")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Object-Lambda_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3ObjectLock(){
        return NodeData.builder()
                .key("S3 Object Lock")
                .text("S3 Object Lock")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Object-Lock_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3OnOutposts(){
        return NodeData.builder()
                .key("S3 On Outposts")
                .text("S3 On Outposts")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-On-Outposts_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3OneZoneIA(){
        return NodeData.builder()
                .key("S3 One Zone IA")
                .text("S3 One Zone IA")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-One-Zone-IA_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3ReplicationTimeControl(){
        return NodeData.builder()
                .key("S3 Replication Time Control")
                .text("S3 Replication Time Control")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Replication-Time-Control_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3Replication(){
        return NodeData.builder()
                .key("S3 Replication")
                .text("S3 Replication")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Replication_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3Select(){
        return NodeData.builder()
                .key("S3 Select")
                .text("S3 Select")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Select_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3StandardIA(){
        return NodeData.builder()
                .key("S3 Standard IA")
                .text("S3 Standard IA")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Standard-IA_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3Standard(){
        return NodeData.builder()
                .key("S3 Standard")
                .text("S3 Standard")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Standard_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3StorageLens(){
        return NodeData.builder()
                .key("S3 Storage Lens")
                .text("S3 Storage Lens")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_S3-Storage-Lens_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addS3VPCAccessPoints(){
        return NodeData.builder()
                .key("S3 VPC Access Points")
                .text("S3 VPC Access Points")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_Amazon-Simple-Storage-Service_VPC-Access-Points_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupAuditManager(){
        return NodeData.builder()
                .key("Backup Audit Manager")
                .text("Backup Audit Manager")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Audit-Manager_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupforCloudFormation(){
        return NodeData.builder()
                .key("Backup for CloudFormation")
                .text("Backup for CloudFormation")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_AWS-Backup-for-AWS-CloudFormation_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupsupportforFSxforNetAppONTAP(){
        return NodeData.builder()
                .key("Backup support for FSx for NetApp ONTAP")
                .text("Backup support for FSx for NetApp ONTAP")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_AWS-Backup-support-for-Amazon-FSx-for-NetApp-ONTAP_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupsupportforS3(){
        return NodeData.builder()
                .key("Backup support for S3")
                .text("Backup support for S3")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_AWS-Backup-support-for-Amazon-S3_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupSupportforVMwareWorkloads(){
        return NodeData.builder()
                .key("Backup Support for VMware Workloads")
                .text("Backup Support for VMware Workloads")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_AWS-Backup-Support-for-VMware-Workloads_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupPlan(){
        return NodeData.builder()
                .key("Backup Plan")
                .text("Backup Plan")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Backup-Plan_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupRestore(){
        return NodeData.builder()
                .key("Backup Restore")
                .text("Backup Restore")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Backup-Restore_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupVault(){
        return NodeData.builder()
                .key("Backup Vault")
                .text("Backup Vault")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Backup-Vault_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupComplianceReporting(){
        return NodeData.builder()
                .key("Backup Compliance Reporting")
                .text("Backup Compliance Reporting")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Compliance-Reporting_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupCompute(){
        return NodeData.builder()
                .key("Backup Compute")
                .text("Backup Compute")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Compute_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupDatabase(){
        return NodeData.builder()
                .key("Backup Database")
                .text("Backup Database")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Database_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupGateway(){
        return NodeData.builder()
                .key("Backup Gateway")
                .text("Backup Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Gateway_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupLegalHold(){
        return NodeData.builder()
                .key("Backup Legal Hold")
                .text("Backup Legal Hold")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Legal-Hold_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupRecoveryPointObjective(){
        return NodeData.builder()
                .key("Backup Recovery Point Objective")
                .text("Backup Recovery Point Objective")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Recovery-Point-Objective_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupRecoveryTimeObjective(){
        return NodeData.builder()
                .key("Backup Recovery Time Objective")
                .text("Backup Recovery Time Objective")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Recovery-Time-Objective_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupStorage(){
        return NodeData.builder()
                .key("Backup Storage")
                .text("Backup Storage")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Storage_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupVaultLock(){
        return NodeData.builder()
                .key("Backup Vault Lock")
                .text("Backup Vault Lock")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Vault-Lock_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupVirtualMachineMonitor(){
        return NodeData.builder()
                .key("Backup Virtual Machine Monitor")
                .text("Backup Virtual Machine Monitor")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Virtual-Machine-Monitor_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addBackupVirtualMachine(){
        return NodeData.builder()
                .key("Backup Virtual Machine")
                .text("Backup Virtual Machine")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Backup_Virtual-Machine_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addSnowballSnowballImportExport(){
        return NodeData.builder()
                .key("Snowball Snowball Import Export")
                .text("Snowball Snowball Import Export")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Snowball_Snowball-Import-Export_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayFSxFileGateway(){
        return NodeData.builder()
                .key("Storage Gateway FSx File Gateway")
                .text("Storage Gateway FSx File Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_Amazon-FSx-File-Gateway_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayS3FileGateway(){
        return NodeData.builder()
                .key("Storage Gateway S3 File Gateway")
                .text("Storage Gateway S3 File Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_Amazon-S3-File-Gateway_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayCachedVolume(){
        return NodeData.builder()
                .key("Storage Gateway Cached Volume")
                .text("Storage Gateway Cached Volume")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_Cached-Volume_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayFileGateway(){
        return NodeData.builder()
                .key("Storage Gateway File Gateway")
                .text("Storage Gateway File Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_File-Gateway_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayNoncachedVolume(){
        return NodeData.builder()
                .key("Storage Gateway Noncached Volume")
                .text("Storage Gateway Noncached Volume")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_Noncached-Volume_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayTapeGateway(){
        return NodeData.builder()
                .key("Storage Gateway Tape Gateway")
                .text("Storage Gateway Tape Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_Tape-Gateway_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayVirtualTapeLibrary(){
        return NodeData.builder()
                .key("Storage Gateway Virtual Tape Library")
                .text("Storage Gateway Virtual Tape Library")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_Virtual-Tape-Library_48.svg")
                .type("Storage")
                .build();
    }

    public NodeData addStorageGatewayVolumeGateway(){
        return NodeData.builder()
                .key("Storage Gateway Volume Gateway")
                .text("Storage Gateway Volume Gateway")
                .source("/img/AWS_icon/Resource_icon/Res_Storage/Res_AWS-Storage-Gateway_Volume-Gateway_48.svg")
                .type("Storage")
                .build();
    }


}