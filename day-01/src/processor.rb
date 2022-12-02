class Processor
  def create_batches(string_input)
    batch_strings = string_input.strip.split(/\n\s*\n/)
    return batches = batch_strings.map{|grp| parse_batch(grp)}
  end

  def parse_batch(string_input)
    return string_input.strip.split("\n").map {|num| num.to_i}
  end

  def sum_batches(batches)
    return batches.map {|batch| batch.inject(:+)}
  end

  def sum_x_highest(nums, x)
    return nums.sort.reverse.take(x).inject(0, :+)
  end

  def process_part_1_solution(string_input)
    batches = create_batches(string_input)
    sums = sum_batches(batches)
    return sums.max
  end

  def process_part_2_solution(string_input)
    batches = create_batches(string_input)
    sums = sum_batches(batches)
    return sum_x_highest(sums, 3)
  end
end