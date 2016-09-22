class openwis::dataservice (
)
{
    include openwis

    class { openwis::middleware::jboss:
    } ->
    class { openwis::middleware::jbossconfigured:
    }
    #include openwis::middleware::jboss
    #include openwis::middleware::jbossconfigured

}