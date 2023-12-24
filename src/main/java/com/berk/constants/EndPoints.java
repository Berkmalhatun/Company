package com.berk.constants;

public class EndPoints {
    /**
     * Uygulama içinde tutulacak tüm erişim noktalarının listesi tutulur.Endpointlere tek bir noktadan erişilebilir.
     */
    public static final String VERSION = "/v1";
    public static final String DEV = "/dev";
    public static final String API = "/api";
    public static final String COMPANY= API+VERSION+DEV+"/company";
    public static final String EMPLOYEE= API+VERSION+DEV+"/employee";

    public static final String CREATE="/create";
    public static final String UPDATE="/update";
    public static final String DELETE="/delete";
    public static final String GET_ALL="/get-all";

}
