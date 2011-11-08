ScalaColliderZ
===============================================================================

## System Requirements ##
sbt 0.11
Get latest scalaz from github and in sbt do "publish-local". This library needs the emptyPromise function which was added very recently, and it's still probably not available elsewhere.

to install do

    sbt

    publish-local

and then add to your sbt file

    "org.friendlyvirus.mn" %% "scalacolliderz" % "0.1"
