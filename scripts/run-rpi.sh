#!/bin/bash
set -x #debug mode

echo "Starting Remote Run.."


function die() {
    echo "ERROR: $1" >&2
    echo "Aborting." >&2
    exit 1
}


HOST=
MAIN_CLASS=

while getopts h:c: opt; do
  case $opt in
  h)
      HOST=$OPTARG
      ;;
  c)
      MAIN_CLASS=$OPTARG
      ;;
  esac
done

shift $((OPTIND - 1))

if [ -z "$HOST" ]; then
   die "Host Cannot Be Empty"
fi

echo "Starting Build.."

sbt assembly
[ $? -ne 0 ] && die "Build failure"



scp target/scala-2.10/scala-rpi.jar $HOST:./scala-rpi.jar
ssh $HOST 'sudo java -Xss8M -Xms256M -jar scala-rpi.jar'
