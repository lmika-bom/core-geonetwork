class openwis::apache_proxy ()
{
    include openwis
    
    # ensure Apache HTTPD installed & configured
    require openwis::middleware::httpd
    
}
