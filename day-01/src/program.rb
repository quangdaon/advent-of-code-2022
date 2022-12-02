require_relative 'processor'

input_file = File.open('inputs/input.txt')
input_txt = input_file.read

processor = Processor.new

part_1_result = processor.process_part_1_solution(input_txt)
puts "Solution for Part 1: " + part_1_result.to_s

part_2_result = processor.process_part_2_solution(input_txt)
puts "Solution for Part 2: " + part_2_result.to_s