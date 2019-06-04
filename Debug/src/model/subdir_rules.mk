################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Each subdirectory must supply rules for building sources it contributes
src/model/%.o: ../src/model/%.cpp $(GEN_OPTS) | $(GEN_FILES)
	@echo 'Building file: "$<"'
	@echo 'Invoking: GNU Compiler'
	"/opt/ti/ccsv8/tools/compiler/gcc-arm-none-eabi-7-2017-q4-major/bin/arm-none-eabi-gcc" -c -mcpu=cortex-m4 -march=armv7e-m -mthumb -mfloat-abi=hard -mfpu=fpv4-sp-d16 -DARM_MATH_CM4 -D__FPU_PRESENT=1 -D__MSP432P401R__ -Dgcc -I"/home/student/git/yahal/include/interface" -I"/home/student/git/yahal/src/FatFs" -I"/home/student/git/yahal/src/driver" -I"/home/student/git/yahal/src/libmad" -I"/home/student/git/yahal/src/platform/msp432" -I"/home/student/git/yahal/src/task" -I"/home/student/git/yahal/src/uGUI" -I"/home/student/git/yahal/src/uGUI/fonts" -I"/home/student/git/yahal/src/util" -I"/home/student/git/yahal/src/platform/msp432/DSP/Include" -I"/opt/ti/ccsv8/ccs_base/arm/include" -I"/opt/ti/ccsv8/ccs_base/arm/include/CMSIS" -I"/home/student/workspace/micow_dev" -I"/opt/ti/ccsv8/tools/compiler/gcc-arm-none-eabi-7-2017-q4-major/arm-none-eabi/include" -Og -g -gdwarf-3 -gstrict-dwarf -Wall -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)"   -fno-threadsafe-statics $(GEN_OPTS__FLAG) -o"$@" "$(shell echo $<)"
	@echo 'Finished building: "$<"'
	@echo ' '


