package com.corptec.etl.dataManipulation.helper;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.corptec.etl.dataManipulation.entity.Customer;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.InputStream;

@Service
public class GetDataFromS3 {

	public void execute() throws IOException {
        final String BUCKET_NAME = "cutomeretl";
        final String OBJECT_NAME = 
//        		"cutomer_data.csv";
        		"customer_data.csv";
        final String ACCESS_KEY = "AKIAQRMXFYTNLSW3K3FN";
        final String SECRET_KEY = "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";

        //1 - Setup S3 Client
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                .withRegion(Regions.US_EAST_1.name())
                .withRegion(Regions.AP_SOUTH_1)
                .build();

        //2 - Get Object from S3 - Option 1 - Write to Disk
        GetObjectRequest request = new GetObjectRequest(BUCKET_NAME, OBJECT_NAME);
        File newFile = new File("customer.csv");

        s3Client.getObject(request, newFile);

        //3 - Get Object from S3 - Option 2 - Process in memory
//        S3Object s3Object = s3Client.getObject(BUCKET_NAME, OBJECT_NAME);
//
//        InputStream inputStream = s3Object.getObjectContent();
//
//        CsvMapper csvMapper = new CsvMapper();
//        CsvSchema schema = CsvSchema.emptySchema().withHeader();
//
//        MappingIterator<Customer> readValues = csvMapper.readerWithTypedSchemaFor(Customer.class)
//                .with(schema)
//                .readValues(inputStream.readAllBytes());
//
//        while (readValues.hasNext()) {
//        	Customer current = readValues.next();
//            System.out.println(current);
//        }


    }
	
}
