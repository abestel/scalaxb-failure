#!/bin/bash

set -e #fail fast

root_dir=`pwd`
tmp_path="/tmp/pwh/"

sbt ";generator/compile ;generator/package ;generator/packageSrc"

mkdir -p modules/failingApp/lib
cp modules/generator/target/scala-2.12/generator_2.12-1.0.jar modules/failingApp/lib/generator_2.12-1.0.jar